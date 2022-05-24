package org.kepler.model;

import javax.persistence.*;
import lombok.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"persons"})
@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
                           CascadeType.REFRESH, CascadeType.DETACH}, 
                           fetch = FetchType.LAZY)
    @JoinTable(
        name = "person_interest",
        joinColumns = @JoinColumn(name = "interest_id"),
        inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> persons;

    public void addPerson(Person person) {
        if(persons == null) {
            persons = new HashSet<Person>();
        }
        persons.add(person);
    }

}