interface NumericTest {
    boolean test(int n, int m);
}

interface NumericFunc {
    int test(int n);
}

interface SomeTest<T> {
    boolean test(T n, T m);
}

interface CaptureTest {
    int test(int n);
}

interface ExceptionTest {
    boolean test();
}

interface IncreaseTest<T> {
    T[] test(T[] n);
}

interface IntPredicate {
    boolean test(int n);
}

class SomeMethods {
    private int m;

    SomeMethods(int m) {
        this.m = m;
    }

    int getM() {
        return m;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }

    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    boolean isFactor(int n) {
        return (n % m) == 0;
    }
}

class Lambda {
    static boolean numTest(IntPredicate p, int n) {
        return p.test(n);
    }

    public static void main(String[] args) {
        NumericTest numericTest;
        int testN = 10, testM = 2;
        System.out.println("N=" + testN + " M=" + testM);
        numericTest = (n, m) -> (n % m) == 0;
        System.out.println("N devided with N without remainder: " + numericTest.test(testN, testM));
        numericTest = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
        System.out.println("N equals M for absolute value: " + numericTest.test(testN, testM));
        numericTest = (n, m) -> n > m;
        System.out.println("N greater M: " + numericTest.test(testN, testM));

        NumericFunc numericFunc = n -> {
            int result = -1;
            for(int i=2 ; i <= n/i ; i++) {
                if((n % i) == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        };
        System.out.println("Smallest devider: " + numericFunc.test(15));

        SomeTest<String> inString = (n, m) -> n.indexOf(m) != -1;
        System.out.println("inString: " + inString.test("abcde", "ab"));
        SomeTest<Integer> isCube = (n, m) -> n == m * m;
        System.out.println("isCube: " + isCube.test(4, 2));

        int someNumber = 10;
        CaptureTest captureTest = n -> {
            // someNumber++; // Error! Don't try to change local variable outside lambda expression! 
            return n + someNumber;
        };
        System.out.println("Captured variable: " + captureTest.test(12));

        ExceptionTest exceptionTest = () -> {
            try {
            throw new ArithmeticException(); 
            } catch(ArithmeticException err) {
                System.out.println(err);
            }
            return true;
        };
        System.out.println("Exception in labda: " + exceptionTest.test());

        IncreaseTest<Integer> increaseTest = (n) -> {
            for(int i=0; i < n.length; i++) {
                ++n[i];
            }
            return n;
        };
        Integer[] testIntegerArray = increaseTest.test(new Integer[] {1, 2, 3});
        for(Integer element : testIntegerArray) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println("isPositive: " + numTest(SomeMethods::isPositive, 14));
        System.out.println("isEven: " + numTest(SomeMethods::isEven, 14));

        SomeMethods someMethods = new SomeMethods(2);
        IntPredicate pred = someMethods::isFactor;
        System.out.println("10 % " + someMethods.getM() + ": " + pred.test(10));

    }
}