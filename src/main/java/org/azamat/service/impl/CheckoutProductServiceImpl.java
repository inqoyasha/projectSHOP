package org.azamat.service.impl;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;
import org.azamat.repository.CheckoutProductRepository;
import org.azamat.repository.CheckoutRepository;
import org.azamat.repository.ProductRepository;
import org.azamat.repository.UserRepository;
import org.azamat.service.CheckoutProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutProductServiceImpl implements CheckoutProductService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutProductRepository checkoutProductRepository;

    @Autowired
    public CheckoutProductServiceImpl(CheckoutRepository checkoutRepository, CheckoutProductRepository checkoutProductRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutProductRepository = checkoutProductRepository;
    }

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
    public int getTotalPrice(List<CheckoutProduct> checkoutProducts) {
        int total = 0;
        for (CheckoutProduct op : checkoutProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    @Override
    public List<CheckoutProduct> findAll() {
        return checkoutProductRepository.findAll();
    }

    @Override
    public List<CheckoutProduct> getAllByCheckout(int id) {
        Checkout checkout = checkoutRepository.findById(id).orElse(new Checkout());
        return checkoutProductRepository.findByCheckout(checkout);
    }

}
