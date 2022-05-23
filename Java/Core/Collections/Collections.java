import java.util.*;


public class Collections {
    public static void println() {
        System.out.println();
    }

    public static <T> void println(T s) {
        System.out.println(s);
    }

    public static <T> void print(T s) {
        System.out.print(s);
    }

    private static void setTest() {
        println("=== Set ===\n");
        // not orderred by input
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(3);
        set.add(3);
        set.add(3);
        println(set);
    }

    private static void listTest() {
        println("\n=== ArrayList ===\n");
        // orderred by input
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(10); // set planned reserved size array
        list.add(5);
        list.add(7);
        list.add(12);
        list.add(4);
        list.add(55);
        list.add(0, null); // insert Null into first position
        list.add(55);
        list.add(24);
        println(list);

        Integer value = list.get(5);
        println("Value in position '5': " + value);
        int index = list.indexOf(55);
        println("Index of element '55':" + index);
        try {
            list.remove(55); // 55 <- index, not object!!!
        } catch (IndexOutOfBoundsException err) {
            println(err);
        }

        list.remove(Integer.valueOf(55)); // now, 55 <- it's object 

        list.forEach(e -> print(e + " "));
        println();
        list.forEach(System.out::print);
        println();

        println(list + " size: " + list.size());
        println("Part of list: " + list.subList(0, 3));

        list.trimToSize(); // cut overmemory size array

        Integer[] intArray = new Integer[(list.size())];
        intArray = list.toArray(intArray);
        for(Integer element : intArray) {
            print(element + " ");
        }
        println();
    }

    public static void linkedListTest() {
        println("\n=== LinkedList ===\n");
        // orderred by input
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("F");
        linkedList.add("D");
        linkedList.add("C");
        linkedList.addFirst("A");
        linkedList.add(1, "A2");
        println(linkedList);
        linkedList.remove("F");
        linkedList.remove(2);
        println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        println(linkedList);
        String val = linkedList.get(0);
        linkedList.set(0, val + " - edited");
        println(linkedList);
    }

    public static void hashSetTest() {
        println("\n=== HashSet ===\n");
        // not orderred by input
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("alpha");
        hashSet.add("beta");
        hashSet.add("gamma");
        hashSet.add("tetta");
        hashSet.add("omega");
        println(hashSet);
    }

    public static void linkedHashSetTest() {
        println("\n=== LinkedHashSet ===\n");
        // orderred by input
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("alpha");
        linkedHashSet.add("beta");
        linkedHashSet.add("gamma");
        linkedHashSet.add("tetta");
        linkedHashSet.add("omega");
        println(linkedHashSet);
    }

    public static void treeSetTest() {
        println("\n=== TreeSet ===\n");
        // Sorted list
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("B");
        treeSet.add("D");
        treeSet.add("A");
        treeSet.add("F");
        treeSet.add("C");
        println(treeSet);
        println(treeSet.subSet("B", "D"));
    }

    public static void arrayDequeTest() {
        println("\n=== ArrayDeque ===\n");
        // ordered, stack
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        arrayDeque.push("a");
        arrayDeque.push("b");
        arrayDeque.push("c");
        arrayDeque.push("d");
        arrayDeque.push("e");
        while(arrayDeque.peek() != null){
            print(arrayDeque.pop() + " ");
        }
        println();
    }

    public static void listIteratorTest() {
        println("\n=== ListIterator ===\n");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        Iterator<String> iter = arrayList.iterator();
        // asc
        while(iter.hasNext()) {
            String element = iter.next();
            print(element + " ");
        }
        println();
        // edit list
        ListIterator<String> listIter = arrayList.listIterator();
        while(listIter.hasNext()) {
            String element = listIter.next();
            listIter.set(element + " --- ");
        }
        print(arrayList);
        // desc
        println();
        while(listIter.hasPrevious()) {
            String element = listIter.previous();
            print(element + " ");
        }
        println();
    }

    public static void spliteratorTest() {
        println("\n=== Spliterator ===\n");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        arrayList.add(1.0);
        arrayList.add(2.0);
        arrayList.add(3.0);
        Spliterator<Double> spliter = arrayList.spliterator();
        while(spliter.tryAdvance(n -> print(n + " / ")));
        println();

        ArrayList<Double> arrayListCudes = new ArrayList<Double>();
        spliter = arrayList.spliterator();
        while(spliter.tryAdvance(n -> arrayListCudes.add(n * n)));
        spliter = arrayListCudes.spliterator();
        spliter.forEachRemaining(n -> print(n + " \\ "));
        println();
    }

    public static void hashMapTest() {
        println("\n=== HashMap ===\n");
        // random sort
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("a", Integer.valueOf(10));
        hashMap.put("eee", Integer.valueOf(50));
        hashMap.put("cc", Integer.valueOf(30));
        hashMap.put("bbb", Integer.valueOf(20));
        hashMap.put("d", Integer.valueOf(40));
        println("Value by key 'a': " + hashMap.get("a"));

        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        for(Map.Entry<String, Integer> element : set) {
            print(element.getKey() + ": " + element.getValue() + " / ");
        }
        println();

        hashMap.put("a", hashMap.get("a") + 90);
        println(hashMap);
    }

    public static void treeMapTest() {
        println("\n=== TreeMap ===\n");
        // sorted
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("a", Integer.valueOf(10));
        treeMap.put("eee", Integer.valueOf(50));
        treeMap.put("cc", Integer.valueOf(30));
        treeMap.put("bbb", Integer.valueOf(20));
        treeMap.put("d", Integer.valueOf(40));
        println("Value by key 'a': " + treeMap.get("a"));
        println(treeMap);
    }

    public static void linkedHashMapTest() {
        println("\n=== LinkedHashMap ===\n");
        // ordered by input
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("a", Integer.valueOf(10));
        linkedHashMap.put("eee", Integer.valueOf(50));
        linkedHashMap.put("cc", Integer.valueOf(30));
        linkedHashMap.put("bbb", Integer.valueOf(20));
        linkedHashMap.put("d", Integer.valueOf(40));
        println("Value by key 'a': " + linkedHashMap.get("a"));
        println(linkedHashMap);
    }

    public static void comparatorTest() {
        println("\n=== Comparator ===\n");
        MyComparator myComparator = new MyComparator();
        TreeSet<String> ts1 = new TreeSet<String>(myComparator);
        ts1.add("c");
        ts1.add("a");
        ts1.add("d");
        ts1.add("b");
        ts1.add("e");
        println(ts1);

        TreeSet<String> ts2 = new TreeSet<String>(myComparator.reversed());
        ts2.addAll(ts1);
        println(ts2);

        TreeSet<String> ts3 = new TreeSet<String>((a, b) -> a.compareTo(b));
        ts3.addAll(ts1);
        println(ts3);

        TreeMap<String, Integer> tm = new TreeMap<String, Integer>(new MyComparatorBySecondWord());
        tm.put("Ivan Ivanov", 10);
        tm.put("Petr Ivanov", 20);
        tm.put("Petya Sidorov", 30);
        tm.put("Grisha Petrov", 40);
        println(tm);

    }


    public static void main(String[] args) {
        // 682
        println("==================== RUN ====================");
        setTest();
        listTest();
        linkedListTest();
        hashSetTest();
        linkedHashSetTest();
        treeSetTest();
        arrayDequeTest();
        listIteratorTest();
        spliteratorTest();
        hashMapTest();
        treeMapTest();
        linkedHashMapTest();
        comparatorTest();
    }
}

class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return a.compareTo(b); // asc
        // return b.compareTo(a); // desc
    }
}

class MyComparatorBySecondWord implements Comparator<String> {
    private String getSecondWord(String str) {
        return str.split(" ")[1];
    }

    public int compare(String a, String b) {
        String aSecondWord = getSecondWord(a);
        String bSecondWord = getSecondWord(b);
        int k = aSecondWord.compareToIgnoreCase(bSecondWord); 
        if(k == 0) { // both second word equals
            return a.compareTo(b);
        }
        return k;
    }
}