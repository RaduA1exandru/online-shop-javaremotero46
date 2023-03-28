package com.sda.onlineshopjavaremotero46.validator;

import com.sda.onlineshopjavaremotero46.dto.UserAccountDto;
import com.sda.onlineshopjavaremotero46.entities.UserAccount;
import com.sda.onlineshopjavaremotero46.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

@Component
public class UserAccountValidator {
    @Autowired
    private UserAccountRepository userAccountRepository;
    public void validate(UserAccountDto userAccountDto, BindingResult bindingResult) {
        Optional<UserAccount> optionalUserAccount = userAccountRepository.findByEmailAddress(userAccountDto.getEmailAddress());
        if (optionalUserAccount.isPresent()){
            FieldError fieldError = new FieldError("userAccountDto", "emailAddress", "Sorry the email is already in use");
            bindingResult.addError(fieldError);
        }
    }
}
