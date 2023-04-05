package com.sda.onlineshopjavaremotero46.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private UserAccount userAccount;
    @OneToMany(mappedBy = "order")
    private List<CartEntry> cartEntryList;
}
