package uit.trungdq.springboot.dto;

public class OrderRequest {
    private Long customerId;
    private String paymentMethod;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerId=" + customerId +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
