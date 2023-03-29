package com.sda.onlineshopjavaremotero46.dto;

import lombok.Data;

@Data
public class UserAccountDto {
    private String fullName;
    private String emailAddress;
    private String password;
    private String address;
    private String userRole;
}
