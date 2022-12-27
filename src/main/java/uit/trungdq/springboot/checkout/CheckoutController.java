package uit.trungdq.springboot.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uit.trungdq.springboot.Utility.ConvertUtility;
import uit.trungdq.springboot.Utility.DataUtility;
import uit.trungdq.springboot.payload.CartItem;
import uit.trungdq.springboot.payload.CheckoutInfo;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping
    public String viewCheckoutPage(Model model) {
        List<CartItem> cartItems = DataUtility.getListCartItems();

        Long customerId = (long) DataUtility.randomWithRange(1, 10);
        List<CartItem> cartItemsByCustomer = getListCartItems(cartItems, customerId);

        // format subTotal
        cartItemsByCustomer.forEach(item -> {
            item.setConvertedSubTotal(ConvertUtility.priceToString(item.getSubtotal()));
        });

        CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItemsByCustomer);

        model.addAttribute("shippingAddress", cartItemsByCustomer.get(0).getCustomerInfoShipping());
        model.addAttribute("checkoutInfo", checkoutInfo);
        model.addAttribute("cartItems", cartItemsByCustomer);
        model.addAttribute("customerId", customerId);

        return "index";
    }

    private List<CartItem> getListCartItems(List<CartItem> cartItems, Long customerId) {
        return cartItems.stream()
                .filter(cartItem -> customerId.equals(cartItem.getCustomer().getId()))
                .collect(Collectors.toList());
    }
}
