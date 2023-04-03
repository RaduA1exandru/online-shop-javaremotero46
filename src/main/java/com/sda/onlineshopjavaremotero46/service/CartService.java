package com.sda.onlineshopjavaremotero46.service;

import com.sda.onlineshopjavaremotero46.dto.ProductQuantityDto;
import com.sda.onlineshopjavaremotero46.entities.Cart;
import com.sda.onlineshopjavaremotero46.entities.CartEntry;
import com.sda.onlineshopjavaremotero46.entities.Product;
import com.sda.onlineshopjavaremotero46.repository.CartEntryRepository;
import com.sda.onlineshopjavaremotero46.repository.CartRepository;
import com.sda.onlineshopjavaremotero46.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;
    public void addToCart(String productId, ProductQuantityDto productQuantityDto, String loggedInUserEmail ){
        CartEntry cartEntry = new CartEntry();
        Cart cart = cartRepository.findByUserAccountEmailAddress(loggedInUserEmail);
        cartEntry.setCart(cart);
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(productId));
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product id is not valid");
        }
        Product product = optionalProduct.get();
        cartEntry.setProduct(product);
        cartEntry.setQuantity(Integer.valueOf(productQuantityDto.getQuantity()));
        cartEntryRepository.save(cartEntry);
    }
}