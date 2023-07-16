package com.kepler.threads.demo7;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;


@Slf4j
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2, true);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread(semaphore);
            threads.add(thread);
            thread.start();
        }

        Thread.sleep(20000);

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private static class MyThread extends Thread {
        private final Semaphore semaphore;

        private MyThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                log.info("{} interrupted.", getName());
            }
        }

        private void runUnsafe() throws InterruptedException {
            while (true) {
                semaphore.acquire();
                try {
                    log.info("{} acquired semaphore.", getName());
                    Thread.sleep(5000);
                } finally {
                    log.info("{} releasing semaphore.", getName());
                    semaphore.release();
                }
            }
        }
    }
}
