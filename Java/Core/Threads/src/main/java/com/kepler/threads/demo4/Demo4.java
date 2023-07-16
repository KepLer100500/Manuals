package com.kepler.threads.demo4;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        new DepositThread(account).start();
        
        log.info("Start trying to get 5_000_000.");
        
        account.withdrawWithWait(5_000_000);
               
        log.info("End trying to get 5_000_000.");
        log.info("Finish money: {}", account.getBalance());
    }
    
    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }
        
        @Override
        public void run() {
            for(int i = 0; i < 5_000_000; i++) {
                account.deposit(1);
            }
        }
        
    }
}
