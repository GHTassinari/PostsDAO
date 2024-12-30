package view;

import java.util.List;

import model.ModelException;
import model.dao.DAOFactory;
import model.dao.PostDAO;
import model.entities.Post;

public class Main {
    public static void main(String[] args) {        
        PostDAO postDAO = (PostDAO) DAOFactory.getDAO(PostDAO.class);
        
        List<Post> postsList = null;
        
        try {
            postsList = postDAO.listAll();
        } catch (ModelException e) {
            System.err.println("Error: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Cause: " + e.getCause().getMessage());
                e.getCause().printStackTrace();
            }
        }
        
        if (postsList != null) {
            for (Post post : postsList) {
                if (post != null) {
                    System.out.println("Post ID: " + post.getPostId());
                    System.out.println("Content: " + post.getContent());
                    System.out.println("Formatted Date: " + post.getFormattedDate());
                    System.out.println("User ID: " + post.getUserId()); 
                    System.out.println();
                }
            }
        }
    }
}
