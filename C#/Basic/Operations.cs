namespace BasicCsharp;

public static class Operations {
    public static void Show() {
        int a = 5, // 101 
            b = 2; // 010

        Console.WriteLine("{0} + {1} = {2}", a, b, a + b);
        Console.WriteLine("{0} - {1} = {2}", a, b, a - b);
        Console.WriteLine("{0} * {1} = {2}", a, b, a * b);
        Console.WriteLine("{0} / {1} = {2}", a, b, a / b);
        Console.WriteLine("{0} / {1} = {2}", a, b, a / Convert.ToDouble(b));
        Console.WriteLine("{0} % {1} = {2}", a, b, a % b);
        Console.WriteLine("{0} % {1} = {2}", a, b, a % b);

        Console.WriteLine("{0} + {1}++ = {2}", a, b, a + b++);
        b--;
        Console.WriteLine("{0} + ++{1} = {2}", a, b, a + ++b);
        b--;

        Console.WriteLine($"{a}({a:b}) >> {b}({b:b}) = {a >> b} ({(a >> b):b})");
        Console.WriteLine("{0} << {1} = {2}({3})", a, b, a << b, Convert.ToString(a << b, 2));
        Console.WriteLine("{0} & {1} = {2}({3})", a, b, a & b, Convert.ToString(a & b, 2));
        Console.WriteLine("{0} | {1} = {2}({3})", a, b, a | b, Convert.ToString(a | b, 2));
        Console.WriteLine("{0} ^ {1} = {2}({3})", a, b, a ^ b, Convert.ToString(a ^ b, 2));
        Console.WriteLine($"~{a}({a:b}) = {~a}({(~a):b})"); // ~ ! NOT

        var c = 0;
        c += 1;
        Console.WriteLine(c);
        Console.WriteLine(!Convert.ToBoolean(c));

        int number = 5;
        Console.WriteLine(number);
        Console.WriteLine(Convert.ToString(number, 2));
        Console.WriteLine(Convert.ToString(number, 2).PadLeft(8, '0'));
        Console.WriteLine($"{number:b}");

        int a1, b1, c1;
        a1 = b1 = c1 = 24 / 2;
        Console.WriteLine(a1);


        byte byte1 = 4, byte2 = 70;
        byte byte3 = (byte)(byte1 + byte2);
        Console.WriteLine(byte3);

        /*
        Safe casting
            byte -> short -> int -> long -> decimal
            int -> double
            short -> float -> double
            char -> int
         */

        bool bool1 = false, bool2 = true;
        bool bool3;
        bool3 = bool1 | bool2;
        bool3 = bool1 || bool2;
        bool3 = bool1 & bool2;
        bool3 = bool1 && bool2;
        bool3 = bool1 ^ bool2;
        bool3 = 1 > 0;
        bool3 = 1 >= 0;
        bool3 = 1 < 0;
        bool3 = 1 <= 0;
        bool3 = !bool3;

        TestClassOp testClass = new TestClassOp(333);
        Console.WriteLine("Class equals: ");
        Console.WriteLine(testClass.id);
        Console.WriteLine(getTestClass(testClass).id);
        Console.WriteLine($"testClass == getTestClass(testClass): {testClass == getTestClass(testClass)}");
        
    }

    static TestClassOp getTestClass(TestClassOp testClass) {
        testClass.id = 500;
        return testClass;
    }

        
}

class TestClassOp(int id) {
    public int id = id;
}