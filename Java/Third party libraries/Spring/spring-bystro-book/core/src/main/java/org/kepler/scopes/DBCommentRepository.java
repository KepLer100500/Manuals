package org.kepler.scopes;


public class DBCommentRepository implements CommentRepository {

    public DBCommentRepository() {
        System.out.println("-> DBCommentRepository instance is created. <Singleton>");
    }

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Save in DB comment: " + comment.getText());
    }
    
}
