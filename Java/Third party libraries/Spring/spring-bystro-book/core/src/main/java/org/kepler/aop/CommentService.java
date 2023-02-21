package org.kepler.aop;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    
    public String publishComment(Comment comment) {
        logger.log(Level.INFO, "Publishing comment: {0}", comment.getText());
        return "SUCCESS";
    }
    
    @ToLog
    public void deleteComment(Comment comment) {
        logger.log(Level.INFO, "Deleting comment: {0}", comment.getText());
    }
}
