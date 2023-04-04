package com.sda.onlineshopjavaremotero46.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartEntryDto {
    private String image;
    private String name;
    private String price;
    private String quantity;
    private String total;

}
