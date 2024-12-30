package model.dao;

import java.util.List;

import model.ModelException;
import model.entities.Post;
import model.entities.User;

public interface PostDAO {
    boolean save(Post post, User user) throws ModelException;
    List<Post> listAll() throws ModelException; 
    boolean update(Post post, User user) throws ModelException; 
    boolean delete(Post post) throws ModelException; 
    Post findById(int postId) throws ModelException;
}