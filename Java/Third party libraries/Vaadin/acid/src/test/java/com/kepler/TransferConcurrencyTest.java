package com.kepler;

import com.kepler.model.Account;
import com.kepler.repository.AccountRepository;
import com.kepler.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TransferConcurrencyTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    private Account a;
    private Account b;

    @BeforeEach
    void setup() {
        accountRepository.deleteAll();

        a = new Account();
        a.setOwner("A");
        a.setBalance(new BigDecimal("1000"));
        a = accountRepository.save(a);

        b = new Account();
        b.setOwner("B");
        b.setBalance(new BigDecimal("1000"));
        b = accountRepository.save(b);
    }

    @Test
    void concurrentTransfersShouldPreserveTotalBalance() throws InterruptedException {
        int threads = 2;
        CountDownLatch latch = new CountDownLatch(threads);

        Runnable transferTask = () -> {
            try {
                accountService.transfer(a.getId(), b.getId(), new BigDecimal("100"));
            } finally {
                latch.countDown();
            }
        };

        Thread t1 = new Thread(transferTask);
        Thread t2 = new Thread(transferTask);

        t1.start();
        t2.start();

        latch.await(); // дождаться завершения обоих потоков

        Account updatedA = accountRepository.findById(a.getId()).orElseThrow();
        Account updatedB = accountRepository.findById(b.getId()).orElseThrow();

        BigDecimal total = updatedA.getBalance().add(updatedB.getBalance());

        System.out.println("A: " + updatedA.getBalance());
        System.out.println("B: " + updatedB.getBalance());

        // Проверка корректности
        assertThat(total).isEqualByComparingTo("2000");
        assertThat(updatedA.getBalance()).isEqualByComparingTo("800");
        assertThat(updatedB.getBalance()).isEqualByComparingTo("1200");
    }
}
