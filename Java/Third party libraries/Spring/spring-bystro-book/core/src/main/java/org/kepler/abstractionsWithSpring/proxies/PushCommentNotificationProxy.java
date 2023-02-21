package org.kepler.abstractionsWithSpring.proxies;

import org.kepler.abstractionsWithSpring.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Push notification: " + comment.getText());
    }
    
}
