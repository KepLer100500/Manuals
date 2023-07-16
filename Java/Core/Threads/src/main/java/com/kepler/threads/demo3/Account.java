package com.kepler.threads.demo3;


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

    public void deposit(long amount) {
        checkNonNegativeAmount(amount);
        synchronized (this) {
            balance += amount;
        }
    }

    public synchronized void withdraw(long amount) {
        checkNonNegativeAmount(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("Not enough money");
        }
        balance -= amount;
    }

    private static void checkNonNegativeAmount(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount money");
        }
    }

}
