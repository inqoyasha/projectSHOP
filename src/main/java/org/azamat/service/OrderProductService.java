package org.azamat.service;

import org.azamat.model.OrderProduct;

public interface OrderProductService {
    OrderProduct create(OrderProduct orderProduct);
    void remove(int id);
    int size();
    OrderProduct findByOrderAndProduct(Integer o_id, Integer p_id);
}
