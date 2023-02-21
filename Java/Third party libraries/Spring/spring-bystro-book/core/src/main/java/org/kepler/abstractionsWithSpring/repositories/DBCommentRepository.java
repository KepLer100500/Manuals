package org.kepler.abstractionsWithSpring.repositories;

import org.kepler.abstractionsWithSpring.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Stored in DB comment: " + comment.getText());
    }
    
}
