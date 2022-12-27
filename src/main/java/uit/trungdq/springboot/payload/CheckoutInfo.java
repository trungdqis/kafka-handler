package uit.trungdq.springboot.payload;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckoutInfo {
    private String productTotal;
    private String shippingCostTotal;
    private String paymentTotal;
    private int deliverDays;

    public String getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(String productTotal) {
        this.productTotal = productTotal;
    }

    public String getShippingCostTotal() {
        return shippingCostTotal;
    }

    public void setShippingCostTotal(String shippingCostTotal) {
        this.shippingCostTotal = shippingCostTotal;
    }

    public String getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(String paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public int getDeliverDays() {
        return deliverDays;
    }

    public void setDeliverDays(int deliverDays) {
        this.deliverDays = deliverDays;
    }

    public Date getDeliverDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, deliverDays);

        return calendar.getTime();
    }

    public String getPaymentTotal4PayPal() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return formatter.format(paymentTotal);
    }
}
