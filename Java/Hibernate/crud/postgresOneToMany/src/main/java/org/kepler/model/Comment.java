package org.kepler.model;

import javax.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"post"})
@Table(name = "comment", schema = "public")
public class Comment extends Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "message")
    private String message;
    //uni-directional
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}