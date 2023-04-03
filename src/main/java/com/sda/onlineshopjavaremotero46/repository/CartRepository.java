package com.sda.onlineshopjavaremotero46.repository;

import com.sda.onlineshopjavaremotero46.entities.Cart;
import com.sda.onlineshopjavaremotero46.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserAccountEmailAddress(String email);
}
