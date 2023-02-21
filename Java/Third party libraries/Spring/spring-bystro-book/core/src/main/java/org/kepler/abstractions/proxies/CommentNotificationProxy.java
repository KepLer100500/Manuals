package org.kepler.abstractions.proxies;

import org.kepler.abstractions.model.Comment;

public interface CommentNotificationProxy {
    public void sendComment(Comment comment);
}
