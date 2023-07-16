package com.kepler.threads.demo5;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Demo5 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }

    private static class Singleton {
        private final int foo;
        private final String bar;

        private static Singleton instance;

        private Singleton() {
            foo = 500;
            bar = "pit-sot";
        }

        public synchronized static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

    }
}
