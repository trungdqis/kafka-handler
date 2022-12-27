package uit.trungdq.springboot.dto;

public class OrderDetailDTO {
    private int quantity;
    private int shippingCost;
    private int unitPrice;
    private int subtotal;
    private Long productId;
    private Long orderId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "quantity=" + quantity +
                ", shippingCost=" + shippingCost +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                ", productId=" + productId +
                ", orderId=" + orderId +
                '}';
    }
}
