namespace BasicCsharp;

public static class Literals {
    public static void Show() {
        Console.WriteLine(true);
        Console.WriteLine(false);

        Console.WriteLine(-10);
        Console.WriteLine(0);
        Console.WriteLine(500);

        Console.WriteLine(0b11);
        Console.WriteLine(0b101);
        Console.WriteLine(0b10001);

        Console.WriteLine(0x0A);
        Console.WriteLine(0xFF);
        Console.WriteLine(0xA1);
        Console.WriteLine(0xB);

        Console.WriteLine(3.14159);
        Console.WriteLine(100.001);
        Console.WriteLine(-0.3);

        Console.WriteLine(3.2e3);
        Console.WriteLine(1.2E-1);

        Console.WriteLine('2');
        Console.WriteLine('A');
        Console.WriteLine('Z');

        Console.WriteLine('\x78');
        Console.WriteLine('\x5A');

        Console.WriteLine('\u0420');
        Console.WriteLine('\u0024');
        Console.WriteLine('\u00AB');

        Console.WriteLine("ololo");
        Console.WriteLine("500\ttrololo");
        Console.WriteLine($"{1 + 2}");
        
        int @int = 5;
    }
}