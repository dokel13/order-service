package com.service.orderservice.controller;

import com.service.orderservice.entity.ProductEntity;
import com.service.orderservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable Integer id) {
        return productService.getById(id);
    }
}
