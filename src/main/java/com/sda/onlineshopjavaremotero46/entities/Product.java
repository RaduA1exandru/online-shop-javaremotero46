package com.sda.onlineshopjavaremotero46.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String name;
    private String description;
    @Nonnull
    private Integer price;
    @Nonnull
    private String category;
    @Nonnull
    private Integer unitsInStock;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] img;

}
