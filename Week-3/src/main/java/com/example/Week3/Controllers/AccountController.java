package com.example.Week3.Controllers;

import com.example.Week3.Models.Account;
import com.example.Week3.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {

    @Autowired
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Get request for all accounts
    @GetMapping("/")
    public List<Account> read() {
        return accountService.readAll();
    }

    // Get Request for specific account. Example: LocalHost:8080/Account/1
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> read(@PathVariable("id") Long id) {
        Account foundAccount = accountService.read(id);
        if (foundAccount == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundAccount);
        }
    }

    // Post Request to add account. Example: Localhost:8080/Account/newAccount. Account in body.
    @PostMapping(value = "/newAccount", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws URISyntaxException {
        Account createdAccount = accountService.create(account);
        if (createdAccount == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdAccount.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdAccount);
        }
    }

    // Put request to overwrite account. Example: "localhost:8080/Account/1". Adjusted account in body.
    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@RequestBody Account Account, @PathVariable Long id) {
        Account updatedAccount = accountService.update(id, Account);
        if (updatedAccount == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedAccount);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
