package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer op_id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Product product;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "o_id")
    private Order order;

    private int quantity;
    private int subPrice;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int quantity, int subPrice) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.subPrice = subPrice;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubPrice(int subPrice) {
        this.subPrice = subPrice;
    }

    public int getSubPrice() {
        return subPrice;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "op_id=" + op_id +
                ", product=" + product +
                ", order=" + order +
                ", quantity=" + quantity +
                ", subPrice=" + subPrice +
                '}';
    }
}
