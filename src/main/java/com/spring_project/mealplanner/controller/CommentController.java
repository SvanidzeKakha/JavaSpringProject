package com.spring_project.mealplanner.controller;

import com.spring_project.mealplanner.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes/{recipeId}/comments")
public class CommentController {

    private List<Comment> comments = new ArrayList<>();

    // POST endpoint to add a comment and rating to a recipe
    @PostMapping
    public ResponseEntity<Comment> addComment(@PathVariable Long recipeId, @RequestBody Comment comment) {
        comment.setRecipeId(recipeId);
        comments.add(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    // GET endpoint to fetch all comments and ratings for a specific recipe
    @GetMapping
    public ResponseEntity<List<Comment>> getCommentsByRecipe(@PathVariable Long recipeId) {
        List<Comment> recipeComments = comments.stream()
                .filter(c -> c.getRecipeId().equals(recipeId))
                .collect(Collectors.toList());
        return new ResponseEntity<>(recipeComments, HttpStatus.OK);
    }
}