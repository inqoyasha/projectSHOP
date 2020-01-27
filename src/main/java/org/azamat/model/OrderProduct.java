package org.azamat.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer op_id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Product product;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "o_id")
    private Order order;
    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getOp_id() {
        return op_id;
    }

    public void setOp_id(Integer op_id) {
        this.op_id = op_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "op_id=" + op_id +
                ", product=" + product +
                ", order=" + order +
                ", quantity=" + quantity +
                '}';
    }
}
