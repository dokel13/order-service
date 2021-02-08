package com.service.orderservice.controller;

import com.service.orderservice.entity.OrderEntity;
import com.service.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderEntity getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/add_product/{productId}")
    public OrderEntity addProductToOrder(@RequestBody OrderEntity order, @PathVariable String productId) {
        return orderService.addProductToOrder(order, productId);
    }

    @PutMapping("/delete_product/{productId}")
    public OrderEntity deleteProductFromOrder(@RequestBody OrderEntity order, @PathVariable String productId) {
        return orderService.deleteProductFromOrder(order, productId);
    }

    @PutMapping("/send_order")
    public void sendOrder(@RequestBody OrderEntity order) {
        orderService.sendOrder(order);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody OrderEntity order) {
        orderService.delete(order);
    }
}
