package org.azamat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer o_id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
    private OrderStatus status;
    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Order(Integer o_id, LocalDate dateCreated, OrderStatus status, List<OrderProduct> orderProducts) {
        this.o_id = o_id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.orderProducts = orderProducts;
    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Transient
    public Double getTotalOrderPrice() {
        Double total = 0d;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct op : orderProducts) {
            total += op.getTotalPrice();
        }

        return total;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

}
