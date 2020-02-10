package org.azamat.service.impl;

        import io.swagger.annotations.OAuth2Definition;
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
    @Autowired
    private HttpSession session;
    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> findAllByOrder(Order order) {
        return orderProductRepository.findByOrder(order);
    }

/*    @Override
    public void update(OrderProduct orderProduct) {
        User userSession = (User)session.getAttribute("connectedUser");
        OrderProduct orderProductFromDB = orderProductRepository.findById(orderProduct.getOp_id()).orElse(null);
        orderProductFromDB.setQuantity(orderProduct.getQuantity());
        orderProductFromDB.setProduct(orderProduct.getProduct());
        orderProductFromDB.setOrder(orderProduct.getOrder());
        orderProductRepository.save(orderProductFromDB);
    }*/

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

    @Override
    public OrderProduct findByOrderAndProduct(Order order, Product product) {
        return orderProductRepository.findByOrderAndProduct(order, product);
    }

}
