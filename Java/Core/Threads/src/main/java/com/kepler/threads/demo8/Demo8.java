package com.kepler.threads.demo8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;


@Slf4j
public class Demo8 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new MyThread(latch).start();
        }

    }

    private static class MyThread extends Thread {
        private final CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                log.info("{} is interrupted.", getName());
            }
        }

        private void runUnsafe() throws InterruptedException {
            Thread.sleep((long) (Math.random() * 10000L));
            log.info("Start init {}", getName());
            latch.countDown();
            latch.await();
            log.info("End init {}", getName());
            Thread.sleep((long) (10000L * Math.random()));
        }
    }
}
