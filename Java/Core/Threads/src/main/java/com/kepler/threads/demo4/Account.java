package com.kepler.threads.demo4;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public synchronized void withdrawWithWait(long amount) throws InterruptedException {
        checkNonNegativeAmount(amount);
        while (balance < amount) { // while, NOT if !!!
            wait();
            if (balance % 1_000_000 == 0) {
                log.info("Wakeup {}", balance);
            }
        }
        balance -= amount;

    }

    public synchronized void withdraw(long amount) {
        checkNonNegativeAmount(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("Not enough money");
        }
        balance -= amount;
    }

    public synchronized void deposit(long amount) {
        checkNonNegativeAmount(amount);
        balance += amount;
        notifyAll();
    }

    private void checkNonNegativeAmount(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount!");
        }
    }
}
