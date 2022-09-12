import java.util.*;


public class Algorithm {
    static class Employee {
        int id;
        String fio;

        Employee(int id, String fio) {
            this.id = id;
            this.fio = fio;
        }

        public int getId() {
            return id;
        }

        public String getFio() {
            return fio;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        @Override
        public String toString() {
            return String.format("id: %s; fio: %s", id, fio);
        }
    }
    static class RecursiveSelectionSort {
        private static int[] swap(int[] arr, int index1, int index2) {
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
            return arr;
        }

        private static int findMin(int[] arr, int index) {
            int minIndex = index - 1;
            if(index < arr.length - 1) { // while arr is not end
                minIndex = findMin(arr, index + 1);
            }
            if(arr[index] < arr[minIndex]) { // from stack - get last arr element, check, next get previous, etc.
                minIndex = index;
            }
            return minIndex;
        }

        public static int[] sort(int[] arr) {
            System.out.println("Recursive selections sort.");
            return sort(arr, 0); // start index is 0
        }

        private static int[] sort(int[] arr, int index) {
            System.out.println(Arrays.toString(arr));
            if(index < arr.length - 1) {            // while arr is not end
                int minIndex = findMin(arr, index); // find min index number
                System.out.println("MinValue: " + arr[minIndex] + ", MinIndex: " + minIndex);
                arr = swap(arr, index, minIndex);   // swap current element with minimal
                arr = sort(arr, index + 1);   // go next element
            }
            return arr;
        }

    }

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

    private static Integer binarySearch(int[] arr, int n) {
        System.out.println("--- Binary search ---");
        int l = 0;
        int h = arr.length - 1;
        int m;
        while(l <= h) {
            m = (l + h) / 2;
            System.out.println("Low: " + l + ", Hight: " + h + ", Mid: " + m);
            if(arr[m] == n) {
                return m; // found position!
            }

            if(arr[m] > n) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return null;
    }

    private static Integer recursiveBinarySearch(int[] arr, int n) {
        System.out.println("--- Recursive binary search ---");
        int l = 0;
        int h = arr.length - 1;
        return recursiveBinarySearch(arr, n, l, h);
    }

    private static Integer recursiveBinarySearch(int[] arr, int n, int l, int h) {
        if(l <= h) {
            int m = (l + h) / 2;
            System.out.println("Low: " + l + ", Hight: " + h + ", Mid: " + m);
            if(arr[m] == n) {
                return m;
            }
            if(arr[m] > n) {
                h = m - 1;
            } else {
                l = m + 1;
            }
            return recursiveBinarySearch(arr, n, l, h);
        } else {
            return null;
        }
    }

    private static int[] selectionSort(int[] arr) {
        System.out.println("Selections sort iterable method.");
        System.out.println("Begin: " + Arrays.toString(arr));
        int minIndex, tmp;
        for(int index = 0; index < arr.length - 1 ;index++) {
            minIndex = index;
            // find smallest index number
            for(int scan = index + 1 ; scan < arr.length; scan++) {
                if(arr[scan] < arr[minIndex]) {
                    minIndex = scan;
                }
            }
            // swap current index with min index number
            tmp = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = tmp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    private static int recursiveSum(int[] arr) {
        return recursiveSum(arr, 0);
    }

    private static int recursiveSum(int[] arr, int index) {
        if(index == arr.length) {
            return 0;
        }
        return arr[index] + recursiveSum(arr, index + 1);
    }

    private static int recursiveLength(int[] arr) {
        return recursiveLength(arr, 0);
    }

    private static int recursiveLength(int[] arr, int index) {
        if(index == arr.length) {
            return 0;
        }
        return 1 + recursiveLength(arr, index + 1);
    }

    private static int[] quickSort(int[] arr) {
        System.out.println("--- Quick sort ---");
        int leftBorder = 0;
        int rightBorder = arr.length - 1;
        return quickSort(arr, leftBorder, rightBorder);
    }

    private static int[] quickSort(int[] arr, int leftBorder, int rightBorder) {
        System.out.println("Current state:     " + Arrays.toString(arr));
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = quickSortFindPivot(arr, leftMarker, rightMarker);
        while(leftMarker <= rightMarker) {
            // move marker, compare getted value with pivot
            while(arr[leftMarker] < pivot) {
                leftMarker++;
            }
            while(arr[rightMarker] > pivot) {
                rightMarker--;
            }
            // swap values if it in different sides of pivot
            if(leftMarker <= rightMarker) {
                arr = quickSortSwap(arr, leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }

        }
        System.out.println("!!! leftMarker: " + leftMarker
                + " rightMarker: " + rightMarker
                + " leftBorder: " + leftBorder
                + " rightBorder: " + rightBorder);
        // make sort in left and right pices of array
        if(leftMarker < rightBorder) {
            arr = quickSort(arr, leftMarker, rightBorder);
        }
        if(rightMarker > leftBorder) {
            arr = quickSort(arr, leftBorder, rightMarker);
        }

        return arr;
    }

    private static int[] quickSortSwap(int arr[], int index1, int index2) {
        System.out.println("Swap: " + arr[index1] + " <-> " + arr[index2]);
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        return arr;
    }

    private static int quickSortFindPivot(int[] arr, int leftMarker, int rightMarker) {
        System.out.println("Pivot: " + arr[(leftMarker + rightMarker) / 2]);
        return arr[(leftMarker + rightMarker) / 2];
    }

    private static Map<Employee, List<Employee>> getGraphEmployee() {
        Employee emp1 = new Employee(1, "user1");
        Employee emp11 = new Employee(11, "user11");
        Employee emp12 = new Employee(12, "user12");
        Employee emp2 = new Employee(2, "user2");
        Employee emp21 = new Employee(21, "user21");
        Employee emp3 = new Employee(3, "user3");
        Employee emp31 = new Employee(31, "user31");
        Employee emp32 = new Employee(32, "user32");
        Employee emp33 = new Employee(33, "user33");
        Employee emp333 = new Employee(333, "admin");

        List<Employee> employeesList1 = new ArrayList<>(List.of(emp11, emp12, emp2));
        List<Employee> employeesList2 = new ArrayList<>(List.of(emp21, emp3));
        List<Employee> employeesList3 = new ArrayList<>(List.of(emp31, emp32, emp33));
        List<Employee> employeesList33 = new ArrayList<>(List.of(emp333));

        Map<Employee, List<Employee>> employees = new HashMap<>(Map.of(
            emp1, employeesList1,
            emp2, employeesList2,
            emp3, employeesList3,
            emp33, employeesList33
        ));

        System.out.println(employees.get(emp1));

        return employees;
    }

    private static Map<String, String[]> getGraph() {
        Map<String, String[]> map = new HashMap<>(Map.of(
            "user1", new String[] {"user11", "user12", "user2"},
            "user2", new String[] {"user21", "user1", "user3"},
            "user3", new String[] {"user31", "user32", "user33"},
            "user33", new String[] {"user331", "user332", "user333"},
            "user333", new String[] {"admin"}
        ));

        return map;
    }

    private static void checkGraph() {
        Map<String, String[]> map = getGraph();
        Deque<String> search = new ArrayDeque<>();
        Set<String> checked = new HashSet<>();
        search.add("user1");                                     // put into deque first user

        while(!search.isEmpty()) {
            String currentUser = search.pop();                   // get user from deque
            checked.add(currentUser);                            // mark user as checked
            System.out.println("currentUser: " + currentUser);
            System.out.println(search);
            if(currentUser.equals("admin")) {                    // main check
                System.out.println("We find admin!");
            } else {
                String[] nextUsersToCheck = map.get(currentUser);
                if(nextUsersToCheck == null) {                   // has not friends
                    continue;                                    // take next user from deque
                }
                for(String user : nextUsersToCheck) {
                    if(user!= null && !checked.contains(user)) { // friend not null and not in checked set
                        search.add(user);                        // add ti deque
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // graph
        System.out.println(getGraphEmployee());
        checkGraph();

        int[] unsorted;
        unsorted = new int[] {5, 7, 8, 2, 1, 3, 6, 4};
        System.out.println("Start values:      " + Arrays.toString(unsorted));
        System.out.println("Quick sort result: " + Arrays.toString(quickSort(unsorted)));
        System.out.println("Sum array elements: " + recursiveSum(new int[] {1, 2, 3, 4}));
        System.out.println("Array length: " + recursiveLength(new int[] {1, 1, 1, 5}));
        System.out.println("Result index: " + binarySearch(new int[] {12, 13, 14, 15, 16, 17, 18, 19}, 14));
        System.out.println("Result index: " + recursiveBinarySearch(new int[] {12, 13, 14, 15, 16, 17, 18, 19}, 18));
        System.out.println("Result: " + Arrays.toString(selectionSort(unsorted)));
        unsorted = new int[] {5, 7, 8, 2, 1, 3, 6, 4};
        System.out.println("Result: " + Arrays.toString(RecursiveSelectionSort.sort(unsorted)));

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

