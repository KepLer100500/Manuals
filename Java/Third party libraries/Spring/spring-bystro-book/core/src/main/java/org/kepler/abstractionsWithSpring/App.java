package org.kepler.abstractionsWithSpring;

import org.kepler.abstractionsWithSpring.model.Comment;
import org.kepler.abstractionsWithSpring.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(new Comment("Some author", "Demo text"));
    }
}
