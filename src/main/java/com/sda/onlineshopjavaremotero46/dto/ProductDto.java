package com.sda.onlineshopjavaremotero46.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class ProductDto {
    private String name;
    private String description;
    private String price;
    private String category;
    private String unitsInStock;

}
