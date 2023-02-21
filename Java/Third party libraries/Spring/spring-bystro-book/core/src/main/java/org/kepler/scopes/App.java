package org.kepler.scopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        System.out.println("--- Start Init beans ---");
        var context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("--- Finish Init beans ---");
        
        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(UserService.class);
        
        Comment comment = new Comment("Test author", "Demo text");
        
        commentService.publishComment(comment);
        userService.publishComment(comment);
        
        boolean repoIsEqual = commentService.getCommentRepository() == userService.getCommentRepository();
        System.out.println("DB repository is same: " + repoIsEqual);
        
        var commentService1 = context.getBean(CommentService.class);
        var commentService2 = context.getBean(CommentService.class);
        
        System.out.println("commentService scope is Prototype, instances must not be equal:");
        System.out.println("Equals: " + (commentService1 == commentService2));
    }
}
