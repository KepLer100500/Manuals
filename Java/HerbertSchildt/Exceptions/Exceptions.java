import java.io.*;


public class Exceptions {
    private static void getArrayElement() {
            int[] a = new int[5];
            try{
                System.out.println("Until exception");
                a[7] = 100;
                System.out.println("This string can not be printed");
            }
            // catch(ArithmeticException) { // not work, because exception is another type!
            catch(ArrayIndexOutOfBoundsException err) {
                System.out.println("After exception");
            }
            System.out.println("After catch() construction");
    }

    private static void devider() {
        int[] numer = {12, 14, 16, 18, 20};
        int[] denon = {0, 2, 0, 2, 0};
        try {
            for(int i=0; i < 500; i++) {
                try {
                    System.out.println(numer[i] + " / " + denon[i] + " = " + numer[i] / denon[i]);
                } 
                catch(ArithmeticException err) {
                    System.out.println("Trying devide for Zero!");
                }
            }
        } 
        catch(ArrayIndexOutOfBoundsException err) {
            System.out.println("Trying get element out of array! Exiting!");
        }
    }

    private static void testThrow() {
        try {
            try {
                System.out.println("Before Throw");
                throw new ArithmeticException(); // Generate exception
            }
            catch(ArithmeticException err) { // err we use below
                System.out.println("After Throw");
                throw err; // Call again exception
            }
        }
        catch(ArithmeticException err) {
            System.out.println("Using again exception err");
            err.printStackTrace(); // Print error message
        }
    }

    private static int testFinally() {
        try {
            return 500; // It work after finally block
        }
        catch(ArithmeticException err) {
            // empty
        }
        finally {
            System.out.println("Finally block work before RETURN statement!!!");
        }
        return 0; // It not work
    }


    private static void generateException() throws ArithmeticException { // in this method maybe error
        System.out.println("Here gerenate exception");
        throw new ArithmeticException();
    }

    private static void workException() {
        try {
            generateException();
        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException err) { // catch some errors
            System.out.println("Work generated exception");
        }
    }


    public static void main(String[] args) {
        getArrayElement();

        devider();

        testThrow();

        System.out.println(testFinally());

        workException();

        // MyException class
        GenerateMyException generateMyException = new GenerateMyException();
    }
}

class MyException extends Exception {
    int x;

    MyException(int x) {
        this.x = x;
    }

    public String toString() {
        return "My Error! X is < 0!: " + x;
    }
}

class GenerateMyException {
    GenerateMyException() {
        for(int i = 5; i >=-5 ; i--) {
            try {
                if(i < 0) {
                    throw new MyException(i);
                }
            }
            catch(MyException err) {
                System.out.println(err);
            }
        }
    }
}