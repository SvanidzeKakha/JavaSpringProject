package com.spring_project.mealplanner.controller;

import com.spring_project.mealplanner.model.Comment;
import com.spring_project.mealplanner.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private CommentService commentService;

    // Add a comment
    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long id, @RequestBody Comment comment) {
        Comment newComment = commentService.addComment(id, comment);
        return ResponseEntity.status(201).body(newComment);
    }

    // Get all comments for a recipe
    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long id) {
        List<Comment> comments = commentService.getComments(id);
        return ResponseEntity.ok(comments);
    }

    // Update a specific comment
    @PutMapping("/{id}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment comment = commentService.updateComment(id, commentId, updatedComment);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    // Delete a specific comment
    @DeleteMapping("/{id}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        boolean deleted = commentService.deleteComment(id, commentId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}