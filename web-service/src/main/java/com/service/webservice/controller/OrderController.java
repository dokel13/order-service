package com.service.webservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api")
@RestController
public class OrderController {

    private static final String ORDERS_URL = "http://localhost:8081/shop/api/order_service/orders";
    private static final String PRODUCTS_URL = "http://localhost:8081/shop/api/order_service/products";

    private final RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Object getOrder(@PathVariable String id) {
        return restTemplate.getForObject(ORDERS_URL + "/" + id, String.class, id);
    }

    @PostMapping
    public Object createOrder(String order) {
        return restTemplate.postForEntity(ORDERS_URL, order, String.class);
    }

    @PutMapping("/add_product/{productId}")
    public void addProductToOrder(String order, @PathVariable String productId) {
        restTemplate.put(ORDERS_URL + "/add_product/" + productId, order);
    }

    @PutMapping("/delete_product/{productId}")
    public void deleteProductFromOrder(String order, @PathVariable String productId) {
        restTemplate.put(ORDERS_URL + "/delete_product/" + productId, order);
    }

    @PutMapping("/send_order")
    public void sendOrder(String order) {
        restTemplate.put(ORDERS_URL + "/send_order", order);
    }

    @DeleteMapping
    public void deleteOrder(String order) {
        restTemplate.delete(ORDERS_URL, order);
    }

    @GetMapping("/products/{id}")
    public Object getProduct(@PathVariable String id) {
        return restTemplate.getForObject(PRODUCTS_URL + "/" + id, String.class, id);
    }
}
