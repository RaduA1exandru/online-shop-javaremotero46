package com.sda.onlineshopjavaremotero46.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "cart")
    private UserAccount userAccount;
    @OneToMany(mappedBy = "cart")
    private List<CartEntry> cartEntryList;
}
