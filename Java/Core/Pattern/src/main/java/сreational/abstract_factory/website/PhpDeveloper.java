package сreational.abstract_factory.website;

import сreational.abstract_factory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer write site code");
    }
}
