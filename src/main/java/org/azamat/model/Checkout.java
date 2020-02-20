package org.azamat.model;

import org.azamat.model.securitymodel.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Table(name = "checkouts")
public class Checkout {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    private CheckoutStatus status;

    @Transient
    private Collection<CheckoutProduct> checkoutProducts;

    public Checkout() {
    }

    public Checkout(Integer id, User user, String name, LocalDateTime dateCreated, CheckoutStatus status, Collection<CheckoutProduct> checkoutProducts) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.dateCreated = dateCreated;
        this.status = status;
        this.checkoutProducts = checkoutProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public CheckoutStatus getStatus() {
        return status;
    }

    public void setStatus(CheckoutStatus status) {
        this.status = status;
    }

    public Collection<CheckoutProduct> getCheckoutProducts() {
        return checkoutProducts;
    }

    public void setCheckoutProducts(Collection<CheckoutProduct> checkoutProducts) {
        this.checkoutProducts = checkoutProducts;
    }
}

