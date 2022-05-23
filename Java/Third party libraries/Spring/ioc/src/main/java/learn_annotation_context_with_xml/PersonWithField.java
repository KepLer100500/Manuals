package learn_annotation_context_with_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("personBeanField")
public class PersonWithField {
    @Autowired
    @Qualifier("myPet1")
    private Pet pet;
    private String name;
    private int age;

    public void callPet() {
        System.out.println("PersonWithField > " + name + " say: Hello my pet! My age is: " + age);
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

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PersonWithField() {
        System.out.println("@@@ PersonWithField bean is created");
    }
}
