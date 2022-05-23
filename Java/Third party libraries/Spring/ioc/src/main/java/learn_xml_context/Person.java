package learn_xml_context;


public class Person {
    private Pet pet;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {

    }

    public Person(Pet pet, String name, int age) {
        this.pet = pet;
        this.name = name;
        this.age = age;
    }

    public void callPet() {
        System.out.println(name + " say: Hello my pet! My age is: " + age);
        pet.say();
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
