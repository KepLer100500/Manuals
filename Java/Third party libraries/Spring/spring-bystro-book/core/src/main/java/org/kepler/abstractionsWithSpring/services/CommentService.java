package org.kepler.abstractionsWithSpring.services;

import org.kepler.abstractionsWithSpring.model.Comment;
import org.kepler.abstractionsWithSpring.proxies.CommentNotificationProxy;
import org.kepler.abstractionsWithSpring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    @Qualifier("EMAIL")
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
