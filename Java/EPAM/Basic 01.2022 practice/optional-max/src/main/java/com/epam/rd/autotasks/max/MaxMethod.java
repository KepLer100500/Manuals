package com.epam.rd.autotasks.max;
import java.util.Arrays;
import java.util.OptionalInt;


public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt result;
        if (values != null && values.length > 0) {
            Arrays.sort(values);
            result = OptionalInt.of(values[values.length - 1]);
        } else {
            result = OptionalInt.empty();
        }

        return result;
    }
}
