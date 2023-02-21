package org.kepler.abstractionsWithSpring.proxies;

import org.kepler.abstractionsWithSpring.model.Comment;

public interface CommentNotificationProxy {
    public void sendComment(Comment comment);
}
