package com.kepler.threads.demo6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
public class Demo6 {
    private static int counter1;
    private static int counter2;
    private static final AtomicInteger counter3 = new AtomicInteger();

    // Bad, not correct working!
    private static int nextInt1() {
        return counter1++;
    }

    // Way #1
    private synchronized static int nextInt2() {
        return counter2++;
    }

    // Way #2
    private static int nextInt3() {
        return counter3.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(
                    () -> {
                        for (int j = 0; j < 1000; j++) {
                            nextInt1();
                            nextInt2();
                            nextInt3();
                        }
                    }
            );
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("Final counter #1 value: {}", counter1);
        log.info("Final counter #2 value: {}", counter2);
        log.info("Final counter #3 value: {}", counter3);
    }
}
