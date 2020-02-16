package org.azamat.service.impl;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;
import org.azamat.repository.CheckoutProductRepository;
import org.azamat.service.CheckoutProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutProductServiceImpl implements CheckoutProductService {

    @Autowired
    private CheckoutProductRepository checkoutProductRepository;

    @Override
    public CheckoutProduct create(CheckoutProduct checkoutProduct) {
        return checkoutProductRepository.save(checkoutProduct);
    }

    @Override
    public CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product) {
        return checkoutProductRepository.findByCheckoutAndProduct(checkout, product);
    }

    @Override
    public Optional<CheckoutProduct> findById(int id) {
        return checkoutProductRepository.findById(id);
    }

    @Override
    public List<CheckoutProduct> findAll() {
        return checkoutProductRepository.findAll();
    }
}
