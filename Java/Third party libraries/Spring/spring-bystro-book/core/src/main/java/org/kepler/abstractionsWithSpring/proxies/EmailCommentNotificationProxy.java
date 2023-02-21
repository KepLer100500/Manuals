package org.kepler.abstractionsWithSpring.proxies;

import org.kepler.abstractionsWithSpring.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Notification by Email: " + comment.getText());
    }
    
}
