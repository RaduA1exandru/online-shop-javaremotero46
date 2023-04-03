package com.sda.onlineshopjavaremotero46.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Cart cart;
    @ManyToOne
    @JoinColumn
    private Product product;

    private Integer quantity;

}
