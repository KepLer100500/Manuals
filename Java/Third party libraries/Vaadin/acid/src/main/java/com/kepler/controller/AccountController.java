package com.kepler.controller;

import com.kepler.model.Account;
import com.kepler.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
    curl -X GET http://localhost:85/api/accounts/get
     */
    @GetMapping("/get")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    /*
    curl -X POST "http://localhost:85/api/accounts/create" --data-urlencode "owner=user1" --data-urlencode "balance=500"
     */
    @PostMapping("/create")
    public Account create(@RequestParam String owner,
                          @RequestParam BigDecimal balance) {
        return accountService.create(owner, balance);
    }

    /*
    curl -X POST "http://localhost:85/api/accounts/transfer" --data-urlencode "fromId=1" --data-urlencode "toId=2" --data-urlencode "balance=500"
     */
    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromId,
                           @RequestParam Long toId,
                           @RequestParam BigDecimal balance) {
        accountService.transfer(fromId, toId, balance);
        return "Success";
    }

}
