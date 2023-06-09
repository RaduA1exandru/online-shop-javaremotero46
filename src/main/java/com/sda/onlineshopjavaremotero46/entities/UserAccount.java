package com.sda.onlineshopjavaremotero46.entities;

import com.sda.onlineshopjavaremotero46.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String fullName;
    private String emailAddress;
    private String password;
    private String address;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Cart cart;
    @OneToMany(mappedBy = "userAccount")
    private List<Order> orderList;
}
