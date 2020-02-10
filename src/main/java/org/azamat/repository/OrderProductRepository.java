package org.azamat.repository;

        import org.azamat.model.OrderProduct;
        import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {
        OrderProduct findByOrderAndProduct(Integer o_id, Integer p_id);
}
