package com.sda.onlineshopjavaremotero46.mapper;

import com.sda.onlineshopjavaremotero46.dto.UserAccountDto;
import com.sda.onlineshopjavaremotero46.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMapper {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount map(UserAccountDto userAccountDto){
        return UserAccount.builder()
                .emailAddress(userAccountDto.getEmailAddress())
                .address(userAccountDto.getAddress())
                .fullName(userAccountDto.getFullName())
                .password(bCryptPasswordEncoder.encode(userAccountDto.getPassword()))
                .build();
    }
}
