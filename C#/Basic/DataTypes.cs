namespace BasicCsharp;

public class DataTypes {
    public static void Show() {
        // 1 byte (not bit!)
        bool status1 = true;
        bool status2 = false;

        // 1 byte
        byte b1 = 33; //  0 - 255
        // byte b1 = -33; - error, byte is unsigned!
        sbyte sb = -101; // -128 - 127

        // 2 byte
        short s = 1; // -32768 - 32767
        ushort us = 2; // 0 - 65535

        // 4 byte
        int i = 5; // -2147483648 - 2147483647
        uint ui = 3; // 0 - 4294967295

        // 8 byte
        long l = long.MaxValue; // –9223372036854775808 - 9223372036854775807
        ulong ul = ulong.MinValue; // 0 - 18446744073709551615
        long ul1 = 500L;
        ulong ul2 = 500UL;

        // 4 byte
        float f1 = float.MaxValue; // -3.4*10^38 - 3.4*10^38 (~7 signs after dot)
        float f2 = 3.567F;

        // 8 byte
        double d1 = 3.57; // -1.7*10^308 - 1.7*10^308 (~15 signs after dot)
        double d2 = 3.57D;

        // 16 byte
        decimal de1 = decimal.MaxValue; // -7.9228*10^28 - 7.9228*10^28 (~28 signs after dot)
        decimal de2 = 3.456M;

        // 2 byte
        char ch1 = 'a';
        char ch2 = '\x5A';
        char ch3 = '\u0420';

        // 24 byte + (2 byte * length)
        string str1 = "Hello";

        // 8 byte
        object obj1 = 500;
        object obj2 = '5';
        object obj3 = "500";

        var value1 = "Hello";

        object? nullvalue = null;

        Console.WriteLine($"""
                           byte: {typeof(byte)}
                           short: {typeof(short)}
                           int: {typeof(int)}
                           long: {typeof(long)}
                           float: {typeof(float)}
                           double: {typeof(double)}
                           decimal: {typeof(decimal)}
                           char: {typeof(char)}
                           string: {typeof(string)}
                           bool: {typeof(bool)}
                           """);

        var test1 = Convert.ToInt32("500");
        var test2 = Convert.ToDouble("500");
        var test3 = Convert.ToDecimal("500");

        Console.WriteLine($"{test1} - {test1.GetType()} / {test2} - {test2.GetType()} / {test3} - {test3.GetType()}");

        State state = State.RUNNING;
        if (state == State.RUNNING) {
            Console.WriteLine(State.RUNNING);    
            Console.WriteLine((sbyte)State.ERROR);    
        }
        
    }

    enum State : sbyte {
        RUNNING = 1,
        STOP = 2,
        ERROR = -1
    }
}