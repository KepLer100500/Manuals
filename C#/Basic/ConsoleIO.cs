namespace BasicCsharp;

public static class ConsoleIO {
    public static void Show() {
        int a = 1, b = 0, c = 500;
        Console.WriteLine($"{a} / {b} / {c}");
        Console.WriteLine("{0} / {1} / {2}", a, b, c);
        
        string greeting = "Input your name: ";
        Console.Write(greeting);
        // string? name = Console.ReadLine(); // now i don't want read console 
        string? name = "KepLer";
        Console.WriteLine($"Hello, {name}!");
        
        
    }
}