package com.pismo.service;

import com.pismo.DTO.AccountDTO;
import com.pismo.DTO.AccountLimitDTO;
import com.pismo.entity.Account;
import com.pismo.exception.AccountNotFoundException;
import com.pismo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountDTO getAccountById(Long id) throws AccountNotFoundException {
        Optional<Account> account = accountRepository.findById(id);

        if(account.isPresent())
            return new AccountDTO(account.get());

        throw new AccountNotFoundException("id-" + id);
    }

    public List<AccountDTO> getAccounts(){
        List<AccountDTO> accountDTOS = new ArrayList<>();

        Iterable<Account> accounts = accountRepository.findAll();

        accounts.forEach(item -> {
            accountDTOS.add(new AccountDTO(item));
        });

        return accountDTOS;
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {

        Account account = new Account(accountDTO);
        account = accountRepository.save(account);

        return new AccountDTO(account);
    }

    public void subtractValue(Long id, AccountLimitDTO accountLimitDTO){
        Optional<Account> account = accountRepository.findById(id);

        if(!account.isPresent())
            throw new AccountNotFoundException("id-" + id);

        Account userAccount = account.get();

        Double availableCreditLimit = userAccount.getAvailableCreditLimit();
        Double availableWithdrawalLimit = userAccount.getAvailableWithdrawalLimit();

        Double creditLimit = availableCreditLimit + accountLimitDTO.getAvailableCreditLimit().getAmount();

        Double withdrawalLimit = availableWithdrawalLimit + accountLimitDTO.getAvailableWithdrawalLimit().getAmount();

        userAccount.setAvailableCreditLimit(creditLimit);
        userAccount.setAvailableWithdrawalLimit(withdrawalLimit);

        accountRepository.save(userAccount);
    }
}
