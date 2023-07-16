package com.kepler.threads.demo1;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo1 {
    public static void main(String[] args) {
        log.info("Run main app");
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
            new Thread(new MyRunnable()).start();
            new Thread(() -> log.info("Lambda - {}", Thread.currentThread().getName())).start();
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            log.info("MyThread - {}", getName());
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("MyRunnable - {}", Thread.currentThread().getName());
        }
    }

}
