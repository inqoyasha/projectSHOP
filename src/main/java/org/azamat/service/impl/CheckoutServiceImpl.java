package org.azamat.service.impl;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.CheckoutStatus;
import org.azamat.model.OrderProduct;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.*;
import org.azamat.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutProductRepository checkoutProductRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    @Autowired
    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, CheckoutProductRepository checkoutProductRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutProductRepository = checkoutProductRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Autowired
    private HttpSession session;
    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public Checkout create(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    @Override
    public Optional<Checkout> getById(int id) {
        return checkoutRepository.findById(id);
    }

    @Override
    public Collection<Checkout> getAllByUser(long id) {
        User user = userRepository.findById(id).orElse(null);
        return checkoutRepository.findByUser(user);
    }


    @Override
    public void addCheckout() {
        User userSession = (User)session.getAttribute("connectedUser");
        Checkout checkout = new Checkout();
        checkoutRepository.save(checkout);
        checkout.setUser(userSession);
        checkout.setName("new order"+checkout.getId());
        checkout.setStatus(CheckoutStatus.SENT_TO_SELLER);
        checkout.setDateCreated(LocalDateTime.now());
        checkoutRepository.save(checkout);

        for (OrderProduct op: orderProductRepository.findAll()) {
            if (op.getOrder().getO_id().equals(userSession.getOrder().getO_id())) {
                CheckoutProduct checkoutProduct = new CheckoutProduct();
                checkoutProduct.setCheckout(checkout);
                checkoutProduct.setProduct(op.getProduct());
                checkoutProduct.setQuantity(op.getQuantity());
                checkoutProduct.setSubPrice(op.getSubPrice());
                checkoutProductRepository.save(checkoutProduct);

                if (op.getProduct().getQuantity() - op.getQuantity() < 0) {
                    throw new RuntimeException("product not found");
                } else {
                    op.getProduct().setQuantity(op.getProduct().getQuantity() - op.getQuantity());
                }

            }
        }
    }
}
