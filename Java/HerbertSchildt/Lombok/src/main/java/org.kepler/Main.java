package org.kepler;

import java.util.*;
import lombok.*;


@Data // used by default RequiredArgsConstructor
class Person {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int age;
}

@Getter
@Setter
@ToString(of = {"name", "age"})
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
class Pet {
    private int id;
    @NonNull
    private String name;
    private int age;
}

@Data
@Builder
class Post {
    private int id;
    private String title;
    private String text;
    @Singular("comment") // comment -> without S!
    private List<String> comments; // commentS <- S!
}

@Value // immutable class
class Car {
    private int id;
    private String title;
    private int type;
}

@Value(staticConstructor = "boatBuilder") // immutable class
class Boat {
    private int id;
    private String title;
    private int type;
}


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Lombok ===");
        Person person = new Person(1, "KepLer", 32);
        System.out.println(person);

        Pet pet1 = new Pet("parrot1"); // age not defined = 0
        System.out.println(pet1);

        Pet pet2 = new Pet(2, "parrot2", 5);
        System.out.println(pet2);

        Post post = Post.builder()
                        .id(42)
                        .title("Some title")
                        .text("Some text")
                        .comment("comment 1") // without S!
                        .comment("comment 2")
                        .comment("comment 3")
                        .build();
        System.out.println(post);

        Car car = new Car(1, "BMW", 10);
        System.out.println(car);
        // car.setType(3); // error! field cannot have a setter!

        Boat boat = Boat.boatBuilder(2, "Kater", 33);
        System.out.println(boat);

    }
}
