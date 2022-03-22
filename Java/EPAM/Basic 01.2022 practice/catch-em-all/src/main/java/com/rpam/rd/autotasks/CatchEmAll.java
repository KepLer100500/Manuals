package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new ArithmeticException("ar");

    public static void riskyMethod() throws Exception {
            throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException fnfErr) {
            throw new IllegalArgumentException("Resource is missing", fnfErr);
        } catch (IOException ioError) {
            throw new IllegalArgumentException("Resource error", ioError);
        } catch (ArithmeticException | NumberFormatException ArithmeticNumberError) {
            System.err.println(ArithmeticNumberError.getMessage().trim());
        }

    }
}
