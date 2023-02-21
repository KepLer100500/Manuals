package org.kepler.scopes;


public class UserService {
    private final CommentRepository commentRepository;
    
    public UserService(CommentRepository commentRepository) {
        System.out.println("-> User service instance is created! <Lazy>");
        this.commentRepository = commentRepository;
    }
    
    public CommentRepository getCommentRepository() {
        return this.commentRepository;
    }
    
    public void publishComment(Comment comment) {
        System.out.println("UserService:");
        commentRepository.storeComment(comment);
    }
}
