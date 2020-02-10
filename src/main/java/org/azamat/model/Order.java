package org.azamat.model;

        import com.fasterxml.jackson.annotation.JsonFormat;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import org.azamat.model.securitymodel.User;

        import javax.persistence.*;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Calendar;
        import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer o_id;
/*    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar dateCreated;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;*/
    @OneToOne(mappedBy ="order", cascade = CascadeType.ALL)
    private User user;
    @Transient
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Order(Integer o_id, List<OrderProduct> orderProducts) {
        this.o_id = o_id;
        this.orderProducts = orderProducts;
    }

    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
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

    @Override
    public String toString() {
        return "Order{" +
                "o_id=" + o_id +
                ", orderProducts.size()=" + orderProducts.size() +
                '}';
    }
}
