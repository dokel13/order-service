package com.service.orderservice.service.impl;

import com.service.orderservice.entity.ProductEntity;
import com.service.orderservice.repository.ProductRepository;
import com.service.orderservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Cacheable("product")
    public ProductEntity getById(Integer id) {
        return productRepository.getById(id);
    }
}
