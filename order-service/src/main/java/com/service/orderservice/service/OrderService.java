package com.service.orderservice.service;

import com.service.orderservice.entity.OrderEntity;

public interface OrderService {

    OrderEntity getOrder(Integer id);

    OrderEntity saveOrder(OrderEntity order);

    OrderEntity addProductToOrder(OrderEntity order, String productId);

    OrderEntity deleteProductFromOrder(OrderEntity order, String productId);

    void sendOrder(OrderEntity order);

    void delete(OrderEntity order);
}
