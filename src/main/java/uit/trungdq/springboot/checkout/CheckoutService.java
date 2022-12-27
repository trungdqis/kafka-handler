package uit.trungdq.springboot.checkout;

import org.springframework.stereotype.Service;
import uit.trungdq.springboot.Utility.ConvertUtility;
import uit.trungdq.springboot.Utility.DataUtility;
import uit.trungdq.springboot.payload.CartItem;
import uit.trungdq.springboot.payload.CheckoutInfo;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class CheckoutService {
    private static final int SHIPPING_COST = 60000;

    public CheckoutInfo prepareCheckout(List<CartItem> cartItems) {
        CheckoutInfo checkoutInfo = new CheckoutInfo();

        int productTotal = calculateProductTotal(cartItems);
        int paymentTotal = productTotal + SHIPPING_COST;

        checkoutInfo.setProductTotal(ConvertUtility.priceToString(productTotal));
        checkoutInfo.setShippingCostTotal(ConvertUtility.priceToString(SHIPPING_COST));
        checkoutInfo.setPaymentTotal(ConvertUtility.priceToString(paymentTotal));

        // random from 2 - 7
        int deliverDays = DataUtility.randomWithRange(2, 7);
        checkoutInfo.setDeliverDays(deliverDays);

        return checkoutInfo;
    }

    private int calculateProductTotal(List<CartItem> cartItems) {
        int total = 0;

        for (CartItem item : cartItems) {
            total += item.getSubtotal();
        }

        return total;
    }
}
