namespace BasicCsharp;

public class Methods {
    void SayHello(string name = "test") {
        Console.WriteLine($"Hello, {name}");
        return;
    }

    void Sum(int x, int y) => Console.WriteLine($"{x} + {y}");

    void Sum(params int[] numbers) {
        Console.WriteLine(numbers.Sum());
    }    
    
    void SumArray(int[] numbers) {
        Console.WriteLine(numbers.Sum());
    }

    int Sub(int x, int y) => x - y;

    void Increment(int x) {
        x++;
    }

    void Increment(ref int x) {
        x++;
    }

    void IncrementReadOnly(ref readonly int x) {
        // x++; error - in parameter is immutable
    }

    void GetRectangle(in int width, int height, out int area, out int perimeter) {
        // width = width * 2; // error - width is marked by "IN" modificator - immutable parameter
        height *= 2;

        area = width * height;
        perimeter = width * height * 2;
    }

    int Factorial(int x) {
        if(x == 1) return 1;
        
        return x * Factorial(x - 1);
    }

    public void Show() {
        SayHello();
        SayHello("ololo");
        Sum(1, 2);
        Sum(y: 2, x: 3);
        Sum(1, 2, 3, 4, 5);
        Sum([1, 2, 3, 4, 5]);
        Sum(new int[] { 1, 2, 3, 4, 5 });
        SumArray(new int[] { 1, 2, 3, 4, 5 });
        SayHello(Convert.ToString(Sub(y: 2, x: 3)));

        int x = 500;
        Console.WriteLine($"x is {x}");
        Increment(x);
        Console.WriteLine($"x is {x}");
        Increment(ref x);
        Console.WriteLine($"x is {x}");

        GetRectangle(10, 20, out var area, out int perimeter);
        Console.WriteLine($"area is {area}, perimeter is {perimeter}");

        Console.WriteLine(Factorial(5));
    }
}