package org.kepler.model;

import javax.persistence.*;
import lombok.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"posts"})
@Table(name = "category", schema = "public")
public class Category extends Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    //bi-directional
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;

    public void addPost(Post post) {
        if(posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
        post.setCategory(this);
    }

}
