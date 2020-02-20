package org.azamat.repository;

import org.azamat.model.Checkout;
import org.azamat.model.securitymodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    List<Checkout> findByUser(User user);
}
