package org.kepler.abstractionsWithSpring.repositories;

import org.kepler.abstractionsWithSpring.model.Comment;

public interface CommentRepository {
    public void storeComment(Comment comment);
}
