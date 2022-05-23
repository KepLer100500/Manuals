package learn_xml_context;


public class Parrot implements Pet {
    @Override
    public void say() {
        System.out.println("Chik - chirik!");
    }

    public void init() {
        System.out.println("# Parrot init!");
    }

    public void destroy() {
        System.out.println("# Parrot destroy!");
    }

    public Parrot() {
        System.out.println("@@@ Parrot bean is created");
    }
}
