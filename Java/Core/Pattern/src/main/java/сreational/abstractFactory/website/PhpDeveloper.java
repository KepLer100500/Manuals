package сreational.abstractFactory.website;

import сreational.abstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer write site code");
    }
}
