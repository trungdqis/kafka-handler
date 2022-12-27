package uit.trungdq.springboot.payload;

public class CartItem {
    private Customer customer;
    private Product product;
    private int quantity;
    private String convertedSubTotal;

    public CartItem() {}

    public CartItem(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return product.getPrice() * quantity;
    }

    public String getConvertedSubTotal() {
        return convertedSubTotal;
    }

    public void setConvertedSubTotal(String convertedSubTotal) {
        this.convertedSubTotal = convertedSubTotal;
    }

    public String getCustomerInfoShipping() {
        return "Receiver: " + customer.getFullName() + ". Address: " + customer.getAddress() + ". Phone Number: " + customer.getPhone();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "customerInfor=" + customer.getFullName() + "|" + customer.getAddress() + "|" + customer.getPhone() +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
