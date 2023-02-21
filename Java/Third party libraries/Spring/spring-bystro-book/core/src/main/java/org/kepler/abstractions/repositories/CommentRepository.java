package org.kepler.abstractions.repositories;

import org.kepler.abstractions.model.Comment;

public interface CommentRepository {
    public void storeComment(Comment comment);
}
