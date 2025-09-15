package com.anas.accountservice.controllers;

import com.anas.accountservice.clients.CustomerRestClient;
import com.anas.accountservice.entities.BankAccount;
import com.anas.accountservice.model.Customer;
import com.anas.accountservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountRestController {

    private  final BankAccountRepository accountRepository;
    private  final CustomerRestClient customerRestClient;

    @GetMapping
    public List<BankAccount> getAllAccounts(){
        return accountRepository.findAll();
    }
    @GetMapping("/{accountId}")
    public BankAccount getAccountById(@PathVariable String accountId){
         BankAccount bankAccount= accountRepository.findById(accountId).get();

         Customer customer = customerRestClient.getCustomer(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
         return bankAccount;
    }
}
