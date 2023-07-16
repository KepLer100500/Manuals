package com.kepler.threads.demo3;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
        log.info("Begin balance: {}", account.getBalance());

        WithdrawTread withdrawTread = new WithdrawTread(account);
        DepositTread depositTread = new DepositTread(account);

        withdrawTread.start();
        depositTread.start();

        withdrawTread.join();
        depositTread.join();

        log.info("End balance: {}", account.getBalance());
    }

    private static class WithdrawTread extends Thread {
        private final Account account;

        private WithdrawTread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositTread extends Thread {
        private final Account account;

        private DepositTread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }

    }
}
