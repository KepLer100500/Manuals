package org.kepler.model;

import javax.persistence.*;
import lombok.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"interests"})
@Entity
@Table(name = "person", schema = "public")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
                           CascadeType.REFRESH, CascadeType.DETACH}, 
                           fetch = FetchType.LAZY)
    @JoinTable(
        name = "person_interest",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests;

    public void addInterest(Interest interest) {
        if(interests == null) {
            interests = new HashSet<Interest>();
        }
        interests.add(interest);
    }
}
