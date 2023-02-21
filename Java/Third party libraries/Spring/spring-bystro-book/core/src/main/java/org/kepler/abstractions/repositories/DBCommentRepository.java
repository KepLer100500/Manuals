package org.kepler.abstractions.repositories;

import org.kepler.abstractions.model.Comment;

public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Stored in DB comment: " + comment.getText());
    }
    
}
