package learn_annotation_context_with_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("personBeanSetter")
public class PersonWithSetters {
    private Pet pet;
    private String name;
    private int age;

    public void callPet() {
        System.out.println("PersonWithSetters > " + name + " say: Hello my pet! My age is: " + age);
        pet.say();
    }

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

    public Pet getPet() {
        return pet;
    }

    @Autowired
    @Qualifier("dog")
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Autowired
    @Qualifier("myPet1")
    public void anyMethod(Pet pet) {
        System.out.println("PersonWithSetters >>> Any method! " + pet);
    }

    public PersonWithSetters() {
        System.out.println("@@@ PersonWithSetters bean is created");
    }
}
