package com.kepler.threads.demo2;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        log.info("= Start app =");

        WorkerThread workerThread = new WorkerThread();
        SleepThread sleepThread = new SleepThread();
        SleepThread sleepThreadNotWait = new SleepThread();

        workerThread.start();
        sleepThread.start();

        sleepThreadNotWait.setDaemon(true); // not wait second sleep thread!!!
        sleepThreadNotWait.start();

        Thread.sleep(100);

        log.info("- Interrupted threads -");
        workerThread.interrupt();
        sleepThread.interrupt();

        log.info("- Joining threads -");
        workerThread.join();
        sleepThread.join();

        log.info("= End app =");
    }

    private static class WorkerThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (long i = 0; i < 1_000_000_000; i++) {
                sum += i;
                if (isInterrupted()) {
                    log.info("+ Worker is interrupted +");
                    break;
                }
            }
        }
    }

    private static class SleepThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                log.info("+ Sleeper is interrupted +");
            }
        }
    }
}
