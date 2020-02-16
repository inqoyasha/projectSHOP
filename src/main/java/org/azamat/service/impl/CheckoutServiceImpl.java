package org.azamat.service.impl;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.CheckoutStatus;
import org.azamat.model.OrderProduct;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.CheckoutProductRepository;
import org.azamat.repository.CheckoutRepository;
import org.azamat.repository.OrderProductRepository;
import org.azamat.repository.ProductRepository;
import org.azamat.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Optional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutProductRepository checkoutProductRepository;
    private final ProductRepository productRepository;
    @Autowired
    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, CheckoutProductRepository checkoutProductRepository, ProductRepository productRepository) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutProductRepository = checkoutProductRepository;
        this.productRepository = productRepository;
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
    public void addCheckout() {
        User userSession = (User)session.getAttribute("connectedUser");
        Checkout checkout = new Checkout();
        checkoutRepository.save(checkout);
        checkout.setUser(userSession);
        checkout.setName("new order"+checkout.getId());
        checkout.setStatus(CheckoutStatus.SENT_TO_SELLER);
        checkout.setDateCreated(Calendar.getInstance());
        checkoutRepository.save(checkout);

        for (OrderProduct op: orderProductRepository.findAll()) {
            if (op.getOrder().getO_id() == userSession.getOrder().getO_id()) {
                CheckoutProduct checkoutProduct = new CheckoutProduct();
                checkoutProduct.setCheckout(checkout);
                checkoutProduct.setProduct(op.getProduct());
                checkoutProduct.setQuantity(op.getQuantity());
                checkoutProductRepository.save(checkoutProduct);
                if (op.getProduct().getQuantity() > 1) {
                    op.getProduct().setQuantity(op.getProduct().getQuantity() - op.getQuantity());
                } else {
                    op.getProduct().setQuantity(0);
                    op.getProduct().setActive(false);
                }
            }
        }
    }
}
