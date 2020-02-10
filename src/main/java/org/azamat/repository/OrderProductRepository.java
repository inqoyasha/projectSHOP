package org.azamat.repository;

        import org.azamat.model.Order;
        import org.azamat.model.OrderProduct;
        import org.azamat.model.Product;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {
        OrderProduct findByOrderAndProduct(Order order, Product product);
        List<OrderProduct> findByOrder(Order order);
}
