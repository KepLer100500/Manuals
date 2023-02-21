package org.kepler.aop;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static final Logger log = Logger.getLogger(App.class.getName());
    
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        CommentService commentService = context.getBean(CommentService.class);
        
        Comment comment = new Comment("Some author", "Demo text");
        
        String returnCode = commentService.publishComment(comment); // Aspect changing returning value!!!
        log.log(Level.INFO, "{0}\n", returnCode);
        
        commentService.deleteComment(comment);
    }
}
