package com.pismo.controller;

import com.pismo.entity.Account;
import com.pismo.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AccountRepository accountRepository;

    private Account account1;
    private Account account2;


    @Before
    public void setUp() throws Exception {
        account1 = new Account(2.4, 3.7);
        account2 = new Account(2.9, 799.9);
        account1 = accountRepository.save(account1);
        account2 = accountRepository.save(account2);
    }

    @Test
    public void whenFindById_thenReturnJson() throws Exception {

        mvc.perform(patch("/v1/accounts/" + account1.getId() )
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"available_credit_limit\": {\"amount\": 123.45 },\"available_withdrawal_limit\": {\"amount\": 123.45 }}"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void whenFindAll_thenReturnJsonArray() throws Exception {

        mvc.perform(get("/v1/accounts/limits")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].available_credit_limit", is(account2.getAvailableCreditLimit())));
    }

    @Test
    public void createNewAccount() throws Exception {

        mvc.perform(post("/v1/accounts/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"available_credit_limit\": 2.3, \"AvailableWithdrawalLimit\": 5.4}"))
                .andExpect(jsonPath("available_credit_limit", is(2.3)))
                .andExpect(status().is2xxSuccessful());

    }
}