package uit.trungdq.springboot.converter;

import uit.trungdq.springboot.dto.OrderDTO;
import uit.trungdq.springboot.payload.Order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class OrderConverter {
    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();

        dto.setCustomerId(order.getCustomer().getId());
        dto.setId(order.getId());
        dto.setDeliverDays(order.getDeliverDays());

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dto.setOrderTime(dateFormatter.format(order.getOrderTime()));

        dto.setTotal(order.getTotal());
        dto.setSubtotal(order.getSubtotal());
        dto.setShippingCost(order.getShippingCost());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setDeliverDate(dateFormatter.format(order.getDeliverDate()));

        return dto;
    }
}
