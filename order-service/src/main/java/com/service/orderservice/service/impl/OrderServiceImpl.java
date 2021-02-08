package com.service.orderservice.service.impl;

import com.service.orderservice.entity.OrderEntity;
import com.service.orderservice.entity.OrderStatus;
import com.service.orderservice.entity.ProductEntity;
import com.service.orderservice.repository.OrderRepository;
import com.service.orderservice.repository.ProductRepository;
import com.service.orderservice.service.OrderService;
import com.service.orderservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.lang.Integer.valueOf;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderEntity getOrder (Integer id) {
        return orderRepository.getById(id);
    }

    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        order.setStatus(OrderStatus.OPEN);

        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public OrderEntity addProductToOrder(OrderEntity order, String productId) {
        ProductEntity product = productService.getById(valueOf(productId));

        if (product.getOrder() != null) {
            order.getProducts().add(product);
            orderRepository.updateOrderProducts(order.getProducts(), order.getId());
        }

        return order;
    }

    @Override
    public OrderEntity deleteProductFromOrder(OrderEntity order, String productId) {
        ProductEntity product = productService.getById(valueOf(productId));
        order.getProducts().remove(product);
        orderRepository.updateOrderProducts(order.getProducts(), order.getId());

        return order;
    }

    @Override
    public void sendOrder(OrderEntity order) {
        orderRepository.sendOrder(OrderStatus.CLOSED.name(), order.getId());
    }

    @Override
    public void delete(OrderEntity order) {
        orderRepository.delete(order);
    }
}
