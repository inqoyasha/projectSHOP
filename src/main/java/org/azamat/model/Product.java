package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer p_id;
    private String productName;
    private String description;
    private String manufacturer;
    private String pictureURL;
    private int price;
    private int quantity;
    private boolean active = true;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }


    public Product(Integer p_id, String productName, String description, String manufacturer, String pictureURL, int price, int quantity, boolean active, Category category) {
        this.p_id = p_id;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.pictureURL = pictureURL;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.category = category;
    }

    public Product(String productName,
                   String description,
                   String manufacturer,
                   String pictureURL,
                   int price,
                   int quantity,
                   boolean active,
                   Category category) {
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.pictureURL = pictureURL;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.category = category;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", active=" + active +
                ", category=" + category +
                '}';
    }
}
