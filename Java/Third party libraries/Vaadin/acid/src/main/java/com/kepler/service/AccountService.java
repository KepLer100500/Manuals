package com.kepler.service;

import com.kepler.model.Account;
import com.kepler.repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Перевод денег между двумя счетами.
     * Применяется @Transactional, чтобы обеспечить атомарность, согласованность, изолированность и устойчивость.
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        /*
        Account from = accountRepository.findById(fromId).orElseThrow(() -> new RuntimeException("User FROM not found!"));
        Account to = accountRepository.findById(toId).orElseThrow(() -> new RuntimeException("User TO not found!"));

        Deadlock!!!
        */
        Account from;
        Account to;

        if (fromId < toId) {
            from = accountRepository.findByIdForUpdate(fromId)
                    .orElseThrow(() -> new EntityNotFoundException("Account " + fromId + " not found"));
            to = accountRepository.findByIdForUpdate(toId)
                    .orElseThrow(() -> new EntityNotFoundException("Account " + toId + " not found"));
        } else {
            to = accountRepository.findByIdForUpdate(toId)
                    .orElseThrow(() -> new EntityNotFoundException("Account " + toId + " not found"));
            from = accountRepository.findByIdForUpdate(fromId)
                    .orElseThrow(() -> new EntityNotFoundException("Account " + fromId + " not found"));
        }

        if (from.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        // A: Атомарность — оба действия (списание/зачисление) происходят как одно целое
        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        // C: Согласованность — баланс не уходит в минус, инварианты соблюдены
        accountRepository.save(from);
        accountRepository.save(to);
        // D: Устойчивость — после коммита изменения сохранятся, даже если сервер упадет
    }

    // I: Изолированность обеспечивается Spring + транзакциями в СУБД

    @Transactional
    public Account create(String owner, BigDecimal balance) {
        Account account = Account.builder()
                .owner(owner)
                .balance(balance)
                .build();
        accountRepository.save(account);
        return account;
    }

    @Transactional
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
