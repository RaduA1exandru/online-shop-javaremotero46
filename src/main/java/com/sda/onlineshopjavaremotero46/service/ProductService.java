package com.sda.onlineshopjavaremotero46.service;

import com.sda.onlineshopjavaremotero46.dto.ProductDto;

import com.sda.onlineshopjavaremotero46.entities.Product;
import com.sda.onlineshopjavaremotero46.mapper.ProductMapper;
import com.sda.onlineshopjavaremotero46.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public void create(ProductDto productDto, MultipartFile multipartFile) {
        Product product = productMapper.map(productDto, multipartFile);
        productRepository.save(product);
    }

    public List<ProductDto> getAllProductDtoList() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product: productList){
            ProductDto productDto = productMapper.map(product);

            productDtoList.add(productDto);
        }
        return productDtoList;

    }
    public Optional<ProductDto> getProductDtoById(String id){
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(id));
        if (optionalProduct.isEmpty()) {
            return Optional.empty();
        }
        ProductDto productDto = productMapper.map(optionalProduct.get());
        return Optional.of(productDto);
    }
}