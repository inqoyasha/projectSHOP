package org.azamat.service;

import org.azamat.model.Order;

public interface OrderService {
    Order create(Order order);
    void update(Order order);
}
