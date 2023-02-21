package org.kepler.abstractions.main;

import org.kepler.abstractions.model.Comment;
import org.kepler.abstractions.proxies.CommentNotificationProxy;
import org.kepler.abstractions.proxies.EmailCommentNotificationProxy;
import org.kepler.abstractions.repositories.CommentRepository;
import org.kepler.abstractions.repositories.DBCommentRepository;
import org.kepler.abstractions.services.CommentService;

public class App {
    public static void main(String[] args) {
        Comment comment = new Comment("Petya", "Eto moy kamment!!!");
        
        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();
        
        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);
        commentService.publishComment(comment);
    }
}
