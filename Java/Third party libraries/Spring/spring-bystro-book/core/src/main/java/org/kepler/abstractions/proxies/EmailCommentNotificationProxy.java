package org.kepler.abstractions.proxies;

import org.kepler.abstractions.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Notification by Email: " + comment.getText());
    }
    
}
