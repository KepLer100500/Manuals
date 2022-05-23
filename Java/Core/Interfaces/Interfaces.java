import series.Series;
import java.lang.Cloneable;


public class Interfaces implements IConstants {
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectClass OC1 = new ObjectClass();
        ObjectClass OC2, OC3;
        OC2 = (ObjectClass) OC1.clone();
        OC3 = OC1;
        System.out.println("Cloned class variable a: " + OC2.a);
        if(OC1.equals(OC2)) { // Links for objects are different! Not Equals!
            System.out.println("OC1 = OC2");
        }
        if(OC1.equals(OC3)) {
            System.out.println("OC1 = OC3");
        }
        System.out.println(OC1.toString());
        // Realize interface
        ByTwos interfaceByTwos = new ByTwos();
        System.out.println("Start value is: 0");
        System.out.println("Next value: " + interfaceByTwos.getNext());
        interfaceByTwos.setStart(5);
        System.out.println("Next value: " + interfaceByTwos.getNext());
        System.out.println("Prev value: " + interfaceByTwos.getPrev());
        System.out.println("Prev value: " + interfaceByTwos.getPrev());
        System.out.println("Reset by: 0");
        interfaceByTwos.reset();
        // Use default method in interface
        for(int elementOfArray: interfaceByTwos.getNextArray(5)) {
            System.out.print(elementOfArray + " ");
        }
        System.out.println();
        // Interface link
        System.out.println("Interface link!");
        ByThrees interfaceByThrees = new ByThrees();
        Series serLink;
        serLink = interfaceByThrees;
        System.out.println("Next value 'interfaceByThrees': " + serLink.getNext());
        serLink = interfaceByTwos;
        System.out.println("Next value: 'interfaceByTwos': " + serLink.getNext());
        // Interface constants
        System.out.println("Max: " + MAX + "\nMin: " + MIN);
        // Interface inhered
        ClassForInterfaceC inheredInterface1 = new ClassForInterfaceC();
        inheredInterface1.printInterfaceA1();
        inheredInterface1.printInterfaceA2();
        inheredInterface1.printInterfaceB();
        // Implements default method in interface
        UserRules user1 = new UserRules();
        System.out.println("User Id: " + user1.getUserId());
        System.out.println("Admin Id: " + user1.getAdminId());
        // Call static method from interface
        System.out.println("Another Id: " + UserRulesInterface.getUniverseUser());
        // Multiple inhered interfaces methods
        MultipleInheredClassC mic = new MultipleInheredClassC();
        mic.test();        
        MultipleInheredClassC1 mic1 = new MultipleInheredClassC1();
        mic1.test();
    }
}

class ObjectClass implements Cloneable {
    // All classes inherit class -> Object
    int a = 55;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() { // redefine Object method toString()
        return "This is my object!!!";
    }

}

class ByTwos implements Series {
    int start; // new variable
    int current; // new variable

    ByTwos() {
        start = 0;
        current = 0;
    }

    public int getNext() {
        current += 2;
        return current;
    }

    public int getPrev() { // new method
        current -= 2;
        return current;
    }

    public void reset() {
        start = 0;
        current = 0;
    }

    public void setStart(int x) {
        start = x;
        current = x;
    }
}

class ByThrees implements Series {
    int start;
    int current;

    ByThrees() {
        start = 0;
        current = 0;
    }

    public int getNext() {
        current += 3;
        return current;
    }

    public int getPrev() {
        current -= 3;
        return current;
    }

    public void reset() {
        start = 0;
        current = 0;
    }

    public void setStart(int x) {
        start = x;
        current = x;
    }
}

interface IConstants {
    int MIN = 0;
    int MAX = 10;
}


interface InterfaceA {
    public void printInterfaceA1();
    public void printInterfaceA2();
}

interface InterfaceB extends InterfaceA {
    public void printInterfaceB();
}

class ClassForInterfaceC implements InterfaceB {
    public void printInterfaceA1() {
        System.out.println("This is implements interface A1");
    }

    public void printInterfaceA2() {
        System.out.println("This is implements interface A2");
    }

    public void printInterfaceB() {
        System.out.println("This is implements interface B");
    } 
}


interface UserRulesInterface {
    int getUserId();

    default int getAdminId() {
        return 1;
    }

    static int getUniverseUser() {
        return 500;
    }
}

class UserRules implements UserRulesInterface {
    public int getUserId() {
        return 100;
    }
}


interface MultipleInheredInterfaceA {
    default void test() {
        System.out.println("Test A");
    }
}

interface MultipleInheredInterfaceB {
    default void test() {
        System.out.println("Test B");
    }
}

class MultipleInheredClassC implements MultipleInheredInterfaceA, MultipleInheredInterfaceB {
    public void test() { // MUST BE!!! Or error! test() contains in both interfaces! Conflict!
        System.out.println("Test C");
    }
}

// Another Inhered
interface MultipleInheredInterfaceA1 {
    default void test() {
        System.out.println("Test A");
    }    
}

interface MultipleInheredInterfaceB1 extends MultipleInheredInterfaceA1 {
    default void test() {
        System.out.println("Test B");
        MultipleInheredInterfaceA1.super.test(); // Run test() from parent "Test A"
    }
}

class MultipleInheredClassC1 implements MultipleInheredInterfaceB1 {
    // No conflict. Used test() from MultipleInheredInterfaceB1
}
