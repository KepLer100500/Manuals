package org.kepler.abstractions.services;

import org.kepler.abstractions.model.Comment;
import org.kepler.abstractions.proxies.CommentNotificationProxy;
import org.kepler.abstractions.repositories.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    
    public CommentService(CommentRepository commentRepository, 
            CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
