package com.anas.accountservice;

import com.anas.accountservice.entities.BankAccount;
import com.anas.accountservice.enums.AccountType;
import com.anas.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount account1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .accountType(AccountType.CURRENT_ACCOUNT)
                    .balance(98888)
                    .currency("MAD")
                    .customerId(1L)
                    .build();

            BankAccount account2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .accountType(AccountType.SAVING_ACCOUNT)
                    .balance(15000)
                    .currency("USD")
                    .customerId(2L)
                    .build();

            // Sauvegarde dans la base
            accountRepository.save(account1);
            accountRepository.save(account2);
        };
    }

}
