package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer p_id;
    private String productName;
    private String pictureURL;
    private double price;

    public Product() {
    }

    public Product(Integer p_id, String productName, String pictureURL, double price) {
        this.p_id = p_id;
        this.productName = productName;
        this.pictureURL = pictureURL;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", productName='" + productName + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", price=" + price +
                '}';
    }
}
