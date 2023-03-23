package com.sda.onlineshopjavaremotero46.service;

import com.sda.onlineshopjavaremotero46.dto.ProductDto;

import com.sda.onlineshopjavaremotero46.entities.Product;
import com.sda.onlineshopjavaremotero46.mapper.ProductMapper;
import com.sda.onlineshopjavaremotero46.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public void create(ProductDto productDto) {
        Product product = productMapper.map(productDto);
        productRepository.save(product);
    }
}