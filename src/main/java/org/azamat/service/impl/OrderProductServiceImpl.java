package org.azamat.service.impl;

        import org.azamat.model.OrderProduct;
        import org.azamat.repository.OrderProductRepository;
        import org.azamat.service.OrderProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) { this.orderProductRepository = orderProductRepository; }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    @Override
    public void remove(int id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public int size() {
        Iterable<OrderProduct> all = orderProductRepository.findAll();
        int sum = 0;
        for (OrderProduct op: all) {
            sum+=op.getQuantity();
        }
        return sum;
    }

}
