package learn_xml_context;


public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Dog say: Gav - gav");
    }

    public void init() {
        System.out.println("# Dog init!");
    }

    public void destroy() {
        System.out.println("# Dog destroy!");
    }

    public Dog() {
        System.out.println("@@@ Dog bean is created");
    }
}
