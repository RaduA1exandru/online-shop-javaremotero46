package com.sda.onlineshopjavaremotero46.repository;

import com.sda.onlineshopjavaremotero46.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
