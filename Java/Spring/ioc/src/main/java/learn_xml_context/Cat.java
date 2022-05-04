package learn_xml_context;


public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Cat say: Mur - mew");
    }

    public void init() {
        System.out.println("# Cat init!");
    }

    public void destroy() {
        System.out.println("# Cat destroy!");
    }

    public Cat() {
        System.out.println("@@@ Cat bean is created");
    }
}
