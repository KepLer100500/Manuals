import java.lang.reflect.*;


public class Basic {
    public static void simpleTypes() {
        int simpleIntNumber = 5;
        double simpleDouble = 5.3;
        int hex = 0xFF;  // 255
        int oct = 011;   // 9
        int bin = 0b101; // 5
        char simbolUnicodeDog = '\u0040'; // @
        char simbolUnicodeAnd = '\u0026'; // &

        System.out.println(simpleIntNumber + " " + simpleDouble + " " 
                            + hex + " " + oct + " " + bin + " " 
                            + simbolUnicodeDog + " " + simbolUnicodeAnd);
    }

    public static void hungryDivide() {
        // hungry AND. If number = 0, dont do divide
        int number = 0;
        if(number != 0 && (10 % number) == 0) {
            System.out.println(10 % number);
        } else {
            System.out.println("Number is 0!!!"); // this print work
        }
    }

    public static void lazyDivide() {
        // lazy AND. If number = 0, be error!
        int number = 0;
        try {
            if(number != 0 & (10 % number) == 0) { // ArithmeticException
                System.out.println(10 % number);
            } else {
                System.out.println("Number is 0!!!");
            }
        } catch(ArithmeticException err) {
            System.out.println(err);
        }
    }

    public static void sideEffectLazyHungryAnd() {
        int i = 10;
        System.out.println("i: " + i);
        if(false && ++i > 5) {

        }
        System.out.println("Hungry: " + i);
        if(false & ++i > 5) {

        }
        System.out.println("Lazy: " + i);
    }

    public static void autoTransformationRules() {
        int int_type = 5;
        byte byte_type = 10;
        int_type = byte_type;
        System.out.println(int_type);
        // byte_type = int_type; // error BYTE type is small than INT
    }

    public static void explicitTransformation() {
        double x, y;
        byte b;
        int i;
        char ch;

        x = 10.0;
        y = 3.0;
        i = (int) (x / y); // here is only whole part
        System.out.println("ToInt -> " + i);

        i = 100;
        b = (byte) i;
        System.out.println("ToByte -> " + b);

        i = 258;
        b = (byte) i; // 258 > max byte length! (256)
        System.out.println("ToByte -> " + b);

        b = 88;
        ch = (char) b;
        System.out.println("ToChar -> " + ch);
    }

    public static void printList() {
        int list1[] = new int[10];
        int list2[] = {1, 2, 3, 4, 5};
        int list3[][] = new int[10][20];
        int list4[][] = new int[2][]; // different length array
        list4[0] = new int[10]; // different length array
        list4[1] = new int[12]; // different length array

        int[] arr1, arr2;
        arr1 = new int[4];
        arr2 = new int[5];
        for(int i=0; i<10; i++) {
            list1[i] = i * i;
        }
        for(int elem: list1) {
            System.out.println(elem);
        }
    }

    public static void linkTwoArrays() {
        // b modify a
        int[] a = {1, 2, 3, 4, 5};
        int[] b;
        b = a;
        b[0] = 500;
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void controlStructures() {
        int i;
        for(i=0; i<10; i++) {
            if(i == 8) {
                break;
            } else if(i == 3) {
                System.out.println("Here, i is eaqual 3");
            }
        }
        switch(i) {
            case 0: System.out.println("This message not printed in this case."); break;
            case 8: System.out.println("Here, i is eaqual 8"); break;
            default: System.out.println("Default message. Not printed in this case.");
        }
        for(int c=(int)'A'; c <= (int)'Z'; c++, i--) {
            System.out.print((char)c + " ");
            if(c == (int)'Z') {
                System.out.print("\n");
            }
        }
        char c = 'a';
        while(c <= 'z') {
            System.out.print(c + " ");
            c++;
        }
        System.out.println("\ni after loop: " + i);
        // break = goto
        mega_break_label: {
        for(int f=0; f<3; f++) {
                for(int j=0; j<3; j++) {
                    if(j == 1) {
                        continue;
                    }
                    if(f == 2) {
                        break mega_break_label;
                    }
                    System.out.println(f + " | " + j);
                }
            }
        }
    }

    // public static void sumUnknownCountParametrs(int ... nums) {
    public static void mySum() {
        // foreach
        int numbers[] = {1, 2, 3};
        int result = 0;
        for(int number: numbers) {
            result += number;
        }
        System.out.println(result);
    }

    public static void stringsOperations() {
        String s1 = "This is first string!";
        String s2 = new String("This is another string!");
        System.out.println("S1 and S2 is equal? " + s1.equals(s2));
        System.out.println("Length S1: " + s1.length());
        System.out.println("First simbol S1: " + s1.charAt(0));
        System.out.println("Compare S1 and S2: " + s1.compareTo(s2));
        System.out.println("First position word 'is' in S1: " + s1.indexOf("is"));
        System.out.println("Last position word 'is' in S1: " + s1.lastIndexOf("is"));
        System.out.println("S1[3:12] - " + s1.substring(3, 12));
    }

    public static void stringParser() {
        String strInt = "50";
        String strDouble = "12.3";
        String strBoolean = "true";
        String strByte = "3";

        int a;
        double b;
        boolean c;
        byte d;

        try {
            a = Integer.parseInt(strInt);
            System.out.println(a);
            b = Double.parseDouble(strDouble);
            System.out.println(b);
            c = Boolean.parseBoolean(strBoolean);
            System.out.println(c);
            d = Byte.parseByte(strByte);
            System.out.println(d);
        }
        catch(NumberFormatException err) {
            System.out.println("Wrong number format");
        }
    }

    public static void main(String args[]) {
        System.out.println("Here is main class!");
        for(String arg : args) {
            System.out.println("This is argument for main program: " + arg);
        }

        String[] methods = {
            "simpleTypes",
            "hungryDivide",
            "lazyDivide",
            "sideEffectLazyHungryAnd",
            "autoTransformationRules",
            "explicitTransformation",
            "printList",
            "linkTwoArrays",
            "controlStructures",
            "mySum",
            "stringsOperations",
            "stringParser"
        };

        for(String method : methods) {
            try {
                (new Basic()).getClass().getMethod(method).invoke(new Basic());
            } catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException err) {
                System.out.println("Method not found or you have not access to this method!");
            }
        }

        /*
        simpleTypes();
        hungryDivide();
        lazyDivide();
        sideEffectLazyHungryAnd();
        autoTransformationRules();
        explicitTransformation();
        printList();
        linkTwoArrays();
        controlStructures();
        sumUnknownCountParametrs();
        mySum();
        stringsOperations();
        stringParser();
        */
    }
}