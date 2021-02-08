package com.service.orderservice.repository;

import com.service.orderservice.entity.OrderEntity;
import com.service.orderservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    OrderEntity getById(Integer id);

    @Modifying
    @Query(value = "UPDATE OrderEntity o SET o.products = ?1 WHERE o.id = ?2")
    void updateOrderProducts(List<ProductEntity> products, Integer orderId);

    @Modifying
    @Query(value = "UPDATE OrderEntity o SET o.status = ?1 WHERE o.id = ?2")
    void sendOrder(String status, Integer id);
}
