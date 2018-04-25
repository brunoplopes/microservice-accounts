package com.pismo.controller;

import com.pismo.DTO.AccountDTO;
import com.pismo.DTO.AccountLimitDTO;
import com.pismo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> getAccountById(@PathVariable(value="id") Long id,
                                     @RequestBody AccountLimitDTO accountLimitDTO) {

        accountService.subtractValue(id, accountLimitDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/limits")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO){
        return accountService.createAccount(accountDTO);
    }
}
