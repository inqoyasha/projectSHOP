package org.azamat.service.impl;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderProductRepository;
import org.azamat.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) { this.orderProductRepository = orderProductRepository; }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    @Autowired
    private HttpSession session;

    @Override
    public List<OrderProduct> findAllByOrder(Order order) {
        return orderProductRepository.findByOrder(order);
    }

    @Override
    public void remove(int id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        User userSession = (User)session.getAttribute("connectedUser");
        Iterable<OrderProduct> all = orderProductRepository.findAll();
        for (OrderProduct op: all) {
            if (op.getOrder().getId() == userSession.getOrder().getId()) {
                this.remove(op.getId());
            }
        }
    }

    @Override
    public int cartCount() {
        User userSession = (User)session.getAttribute("connectedUser");
        if (userSession == null) {
            return 0;
        }
        List<OrderProduct> orderProducts = this.findAllByOrder(userSession.getOrder());
        int sum = 0;
        if (orderProducts == null) {
            return 0;
        }
        for (OrderProduct op: orderProducts) {
            sum+=op.getQuantity();
        }
        return sum;
    }

    @Override
    public int getTotalPrice(List<OrderProduct> orderProducts) {
        int total = 0;
        for (OrderProduct op : orderProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    @Override
    public OrderProduct findByOrderAndProduct(Order order, Product product) {
        return orderProductRepository.findByOrderAndProduct(order, product);
    }

}
