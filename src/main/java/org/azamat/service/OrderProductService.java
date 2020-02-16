package org.azamat.service;

import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;

import java.util.List;

public interface OrderProductService {
    OrderProduct create(OrderProduct orderProduct);
    List<OrderProduct> findAllByOrder(Order order);
//    void update(OrderProduct orderProduct);
    void remove(int id);
    void removeAll();
    int cartCount(List<OrderProduct> orderProducts);
    double getTotalPrice(List<OrderProduct> orderProducts);
    OrderProduct findByOrderAndProduct(Order order, Product product);
}

