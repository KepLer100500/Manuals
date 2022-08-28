package сreational.abstract_factory.banking;

import сreational.abstract_factory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Developer writes Java code for banking system");
    }
}
