package org.azamat.service;

import org.azamat.model.OrderProduct;

public interface OrderProductService {
    OrderProduct create(OrderProduct orderProduct);
    void remove(int id);
}
