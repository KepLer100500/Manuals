namespace BasicCsharp;

public static class Arrays {
    public static void Show() {
        int[] nums1 = new int[10];
        int[] nums2 = new int[4] { 1, 2, 3, 5 };
        int[] nums3 = new int[] { 1, 2, 3, 5 };
        int[] nums4 = new[] { 1, 2, 3, 5 };
        int[] nums5 = { 1, 2, 3, 5 };

        string[] people = { "Tom", "Sam", "Bob" };

        int[] nums6 = [1, 2, 3, 5]; // C# 12 collections syntax
        int[] nums7 = []; // C# 12 collections syntax

        Console.WriteLine($"{nums1} --- {nums1.Length}");

        Console.WriteLine(people[people.Length - 1]);
        Console.WriteLine(people[^1]);
        Console.WriteLine(people[2]);

        foreach (var num in nums2) {
            Console.WriteLine(num);
        }

        int[,] nums11;
        int[,] nums22 = new int[2, 3];
        int[,] nums33 = new int[2, 3] { { 0, 1, 2 }, { 3, 4, 5 } };
        int[,] nums44 = new int[,] { { 0, 1, 2 }, { 3, 4, 5 } };
        int[,] nums55 = new[,] { { 0, 1, 2 }, { 3, 4, 5 } };
        int[,] nums66 = { { 0, 1, 2 }, { 3, 4, 5 } };


        int[,,] nums333 = new int[2, 3, 4];

        int[,] numbers1 = { { 1, 2, 3 }, { 4, 5, 6 } };
        foreach (int i in numbers1) {
            Console.Write($"{i} ");
        }

        int[][] nums = new int[3][];
        nums[0] = new int[2] { 1, 2 }; // выделяем память для первого подмассива
        nums[1] = new int[3] { 1, 2, 3 }; // выделяем память для второго подмассива
        nums[2] = new int[5] { 1, 2, 3, 4, 5 }; // выделяем память для третьего подмассива


        int[][] numbers = {
            new int[] { 1, 2 },
            [1, 2, 3],
            new int[] { 1, 2, 3, 4, 5 }
        };

        foreach (int[] n in numbers) {
            foreach (var item in n) {
                Console.Write($"{item} ");
            }
        }
        
        
    }
}