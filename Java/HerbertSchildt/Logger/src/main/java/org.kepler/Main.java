package org.kepler;

import org.slf4j.*;
import static java.lang.Math.random;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int choise;
        for(int i = 0; i <= 100; i++) {
            choise = (int)(5 * random() + 1);

            switch(choise) {
                case 1: logger.trace("{} === {}", i, "Trace!"); break;
                case 2: logger.debug("{} === {}", i, "Debug!"); break;
                case 3: logger.info("{} === {}", i, "Information!"); break;
                case 4: logger.warn("{} === {}", i, "Warning!"); break;
                case 5: logger.error("{} === {}", i, "Error!"); break;
                default: logger.trace("{} === {}", i, "Trace!");
            }
        }
    }
}
