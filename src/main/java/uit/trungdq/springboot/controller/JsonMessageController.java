package uit.trungdq.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.trungdq.springboot.Utility.DataUtility;
import uit.trungdq.springboot.checkout.CheckoutService;
import uit.trungdq.springboot.converter.OrderConverter;
import uit.trungdq.springboot.converter.OrderDetailConverter;
import uit.trungdq.springboot.dto.OrderRequest;
import uit.trungdq.springboot.kafka.JsonKafkaProducer;
import uit.trungdq.springboot.payload.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    @Autowired
    private CheckoutService checkoutService;
    private final JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody OrderRequest orderRequest) {
        Long customerId = orderRequest.getCustomerId();
        List<CartItem> cartItems = DataUtility.getListCartItems();
        List<CartItem> cartItemsByCustomer = cartItems.stream()
                .filter(cartItem -> customerId.equals(cartItem.getCustomer().getId()))
                .collect(Collectors.toList());

        CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItemsByCustomer);

        Order newOrder = new Order();
        newOrder.setOrderTime(new Date());
        newOrder.setCustomer(DataUtility.getListCustomers().stream()
                .filter(item -> customerId.equals(item.getId()))
                .findFirst().get());

        newOrder.setSubtotal(Integer.parseInt(checkoutInfo.getProductTotal().replaceAll(",", "")));
        newOrder.setShippingCost(Integer.parseInt(checkoutInfo.getShippingCostTotal().replaceAll(",", "")));
        newOrder.setTotal(Integer.parseInt(checkoutInfo.getPaymentTotal().replaceAll(",", "")));
        newOrder.setPaymentMethod(orderRequest.getPaymentMethod());
        newOrder.setDeliverDays(checkoutInfo.getDeliverDays());
        newOrder.setDeliverDate(checkoutInfo.getDeliverDate());
        newOrder.setShippingAddress(cartItemsByCustomer.get(0).getCustomerInfoShipping());

        System.out.println(OrderConverter.toDTO(newOrder));
       kafkaProducer.sendMessage(OrderConverter.toDTO(newOrder));

        // OrderDetail
        Set<OrderDetail> orderDetails = newOrder.getOrderDetails();

        for (CartItem cartItem : cartItemsByCustomer) {
            Product product = cartItem.getProduct();

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(newOrder);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setUnitPrice(product.getPrice());
            orderDetail.setSubtotal(cartItem.getSubtotal());
            orderDetail.setShippingCost(newOrder.getShippingCost());

//            kafkaProducer.sendMessage(OrderDetailConverter.toDTO(orderDetail));

            System.out.println(OrderDetailConverter.toDTO(orderDetail));

            orderDetails.add(orderDetail);
        }

        return ResponseEntity.ok("Json message sent to kafka topic" + " with " + orderRequest);
    }
}
