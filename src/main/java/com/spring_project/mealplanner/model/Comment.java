package com.spring_project.mealplanner.model;

public class Comment {
    private Long id;
    private Long recipeId;
    private Long userId;
    private int rating; // Rating out of 5
    private String comment;

    // Constructor
    public Comment(Long userId, int rating, String comment, Long id) {
        this.id = id;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for recipeId
    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Getter and Setter for rating
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Getter and Setter for comment
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}