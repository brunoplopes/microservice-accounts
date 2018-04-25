package com.pismo.service;

import com.pismo.DTO.AccountDTO;
import com.pismo.entity.Account;
import com.pismo.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account(2.4, 3.7);
        account = accountRepository.save(account);
    }

    @Test
    public void whenFindById_thenReturnAccountDTO() throws Exception {
        AccountDTO accountDTO = accountService.getAccountById(account.getId());

        assertEquals(account.getAvailableCreditLimit(), accountDTO.getAvailableCreditLimit());
        assertEquals(account.getAvailableWithdrawalLimit(), accountDTO.getAvailableWithdrawalLimit());
    }

    @Test
    public void getAccounts() {
    }
}