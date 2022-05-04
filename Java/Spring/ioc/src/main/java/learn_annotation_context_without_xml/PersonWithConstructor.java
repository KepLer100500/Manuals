package learn_annotation_context_without_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("personBeanConstructor")
public class PersonWithConstructor {
    private Pet pet;
    private String name;
    private int age;

    public PersonWithConstructor() {

    }

    @Autowired
    public PersonWithConstructor(@Qualifier("dog") Pet pet, 
                                @Value("${person.name}") String name,  
                                @Value("${person.age}") int age) {
        System.out.println("@@@ PersonWithField bean is created");
        this.pet = pet;
        this.name = name;
        this.age = age;
    }

    public void callPet() {
        System.out.println("PersonWithConstructor > " + name + " say: Hello my pet! My age is: " + age);
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
}
