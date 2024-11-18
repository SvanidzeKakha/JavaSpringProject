package com.spring_project.mealplanner.service;

import com.spring_project.mealplanner.model.Comment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService {

    // Temporary in-memory storage for comments. Replace with proper storage later if needed.
    private final Map<Long, Map<Long, Comment>> commentsByRecipe = new HashMap<>();

    // Method to add a new comment
    public Comment addComment(Long recipeId, Comment comment) {
        commentsByRecipe.putIfAbsent(recipeId, new HashMap<>());
        long commentId = commentsByRecipe.get(recipeId).size() + 1L;
        comment.setId(commentId); // Assuming Comment has an ID field
        commentsByRecipe.get(recipeId).put(commentId, comment);
        return comment;
    }

    // Method to get all comments for a specific recipe
    public List<Comment> getComments(Long recipeId) {
        return commentsByRecipe.getOrDefault(recipeId, new HashMap<>()).values().stream().collect(Collectors.toList());
    }

    // Method to update a comment
    public Comment updateComment(Long recipeId, Long commentId, Comment updatedComment) {
        Map<Long, Comment> recipeComments = commentsByRecipe.get(recipeId);
        if (recipeComments != null && recipeComments.containsKey(commentId)) {
            updatedComment.setId(commentId); // Ensure ID is set correctly
            recipeComments.put(commentId, updatedComment);
            return updatedComment;
        }
        return null; // Comment not found
    }

    // Method to delete a comment
    public boolean deleteComment(Long recipeId, Long commentId) {
        Map<Long, Comment> recipeComments = commentsByRecipe.get(recipeId);
        return recipeComments != null && recipeComments.remove(commentId) != null; // Deletion successful
// Comment not found
    }
}