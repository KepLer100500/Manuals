package learn_annotation_context_bean;

import org.springframework.beans.factory.annotation.Value;


public class Person {
    private Pet pet;

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;

    public Person() {

    }

    public Person(Pet pet) {
        System.out.println("@@@ Person bean is created");
        this.pet = pet;
    }

    public void callPet() {
        System.out.println("Person > " + name + " say: Hello my pet! My age is: " + age);
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
