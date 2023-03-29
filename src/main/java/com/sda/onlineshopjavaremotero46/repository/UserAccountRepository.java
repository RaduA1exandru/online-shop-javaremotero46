package com.sda.onlineshopjavaremotero46.repository;

import com.sda.onlineshopjavaremotero46.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmailAddress(String emailAddress);
}
