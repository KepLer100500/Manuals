public class Algorithm {
    public static int[] bubbleSort(int list[]) {
        for(int i=1; i<list.length; i++) {
            for(int j=list.length-1; j>=i; j--) {
                if(list[j-1] > list[j]) {
                    list[j] = list[j] - list[j-1];
                    list[j-1] = list[j] + list[j-1];
                    list[j] = list[j-1] - list[j];
                }
            }
        }
        return list;
    }

    public static void swapNumbers(int a, int b) {
        System.out.println("a = " + a + " b = " + b);
        a = a - b;
        b = b + a;
        a = b - a;
        System.out.println("a = " + a + " b = " + b);
    }

    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return factorial(n-1) * n;
    }

    public static int recursePrintDesc(int n) {
        // 5, 4, 3, 2, 1
        if(n == 1) {
            System.out.println(1);
            return 1;
        } 
        System.out.print(n + " ");
        return recursePrintDesc(n-1);
    }

    public static int recursePrintAsc(int n) {
        // 1, 2, 3, 4, 5
        if(n == 5) {
            System.out.println(5);
            return 5;
        }
        System.out.print(n + " ");
        return recursePrintAsc(n+1);        
    }

    public static String recursiveGetArrayElements(String[] arr) {
        if(arr.length == 1) {
            System.out.println(arr[0]);
            return arr[0];
        }
        System.out.println(arr[arr.length-1]);
        String[] newArr = new String[arr.length-1];
        for(int i=0; i < arr.length-1; i++) {
            newArr[i] = arr[i];
        }
        return recursiveGetArrayElements(newArr);
    }

    public static void main(String[] args) {
        for(int i : bubbleSort(new int[] {1, 4, 2, 5, 3})) {
            System.out.print(i + " ");
        }
        System.out.println();

        swapNumbers(5, 8);

        System.out.println("factorial 5: " + factorial(5));

        recursePrintDesc(5);

        recursePrintAsc(1);
        
        recursiveGetArrayElements(new String[] {"One", "Two", "Three"}); // desc
    }
}