package uit.trungdq.springboot.payload;

public class Product {
    private Long id;
    private String name;
    private String alias;
    private int price;
    private String mainImage;
    private String description;
    private String brand;

    public Product() {}

    public Product(Long id, String name, String alias, int price, String mainImage, String description, String brand) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.price = price;
        this.mainImage = mainImage;
        this.description = description;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMainImage() {
        return "/images/" + alias + ".png";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", price=" + price +
                ", mainImage='" + mainImage + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
