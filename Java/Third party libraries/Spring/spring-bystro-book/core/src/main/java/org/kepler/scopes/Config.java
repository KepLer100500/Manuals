package org.kepler.scopes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Configuration
public class Config {
    @Bean
    CommentRepository commentRepository() {
        return new DBCommentRepository();
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    CommentService commentService(CommentRepository commentRepository) {
        return new CommentService(commentRepository);
    }
    
    @Bean
    @Lazy
    UserService userService(CommentRepository commentRepository) {
        return new UserService(commentRepository);
    }
}
