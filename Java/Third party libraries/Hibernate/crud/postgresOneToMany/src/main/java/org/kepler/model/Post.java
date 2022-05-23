package org.kepler.model;

import javax.persistence.*;
import lombok.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"category"})
@Table(name = "post", schema = "public")
public class Post extends Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "full_text")
    private String fullText;
    // bi-directional
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    //uni-directional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    public void addMessage(Comment comment) {
        if(comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}