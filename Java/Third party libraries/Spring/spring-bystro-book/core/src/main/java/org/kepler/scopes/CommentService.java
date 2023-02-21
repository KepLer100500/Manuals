package org.kepler.scopes;


public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        System.out.println("-> Comment service instance is created! <Prototype>");
        this.commentRepository = commentRepository;
    }
    
    public CommentRepository getCommentRepository() {
        return this.commentRepository;
    }

    public void publishComment(Comment comment) {
        System.out.println("CommentService:");
        this.commentRepository.storeComment(comment);
    }
}
