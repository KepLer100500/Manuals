package сreational.abstractFactory.banking;

import сreational.abstractFactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes Java code for banking system");
    }
}
