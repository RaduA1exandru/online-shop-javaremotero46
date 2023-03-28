package com.sda.onlineshopjavaremotero46.service;

import com.sda.onlineshopjavaremotero46.dto.UserAccountDto;
import com.sda.onlineshopjavaremotero46.entities.UserAccount;
import com.sda.onlineshopjavaremotero46.mapper.UserAccountMapper;
import com.sda.onlineshopjavaremotero46.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountRepository userRepository;

    public void registerUser(UserAccountDto userAccountDto){
        UserAccount userAccount = userAccountMapper.map(userAccountDto);
        userRepository.save(userAccount);
    }
}
