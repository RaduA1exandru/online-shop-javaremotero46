package com.sda.onlineshopjavaremotero46.service;

import com.sda.onlineshopjavaremotero46.entities.Cart;
import com.sda.onlineshopjavaremotero46.entities.CartEntry;
import com.sda.onlineshopjavaremotero46.entities.Order;
import com.sda.onlineshopjavaremotero46.repository.CartEntryRepository;
import com.sda.onlineshopjavaremotero46.repository.CartRepository;
import com.sda.onlineshopjavaremotero46.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;

    public void placeOrder(String loggedInUserEmail){
        Cart cart = cartRepository.findByUserAccountEmailAddress(loggedInUserEmail);
        Order order = new Order();
        order.setUserAccount(cart.getUserAccount());
//        order.setCartEntryList(cart.getCartEntryList());
        orderRepository.save(order);
        for (CartEntry cartEntry: cart.getCartEntryList()){
            cartEntry.setCart(null);
            cartEntry.setOrder(order);

            cartEntryRepository.save(cartEntry);
        }
    }
}