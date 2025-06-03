namespace BasicCsharp;

public static class Conditionals {
    public static void Show() {
        if (2 > 1 && 2 < 3) {
            // something
        } else if (2 > 3 && 2 < 4) {
            // something
        } else {
            // something
        }

        int z = 1 > 2 ? 500 : 501;
        object zz = 1 > 2 ? 0 : "0";

        for (int i = 0; i < 10; i++) {
            // something
        }

        int index = 0;
        while (index < 10) {
            // something
            if (index == 500) {
                continue;
            }

            index++;
        }

        do {
            // something
            if (index == 500) {
                break;
            }

            index++;
        } while (index < 20);

        foreach (char c in "text") {
            Console.WriteLine(c);
        }

        foreach (var c in "text") {
            Console.WriteLine(c);
        }

        string s = "sum";

        switch (s) {
            case "sum": Console.WriteLine("+"); break;
            case "sub":
                Console.WriteLine("-");
                break;
            case "mul": Console.WriteLine("*"); break;
            default: Console.WriteLine("undefined command"); break;
        }

        int doOperation = s switch {
            "sum" => 10,
            "sub" => 1,
            "mul" => 2,
            _ => 0,
        };
        Console.WriteLine($"do operation: {doOperation}");
    }
}