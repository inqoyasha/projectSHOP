package org.azamat.service;

import org.azamat.model.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();
    Order create(Order order);
    void update(Order order);
    void remove(int id);
}
