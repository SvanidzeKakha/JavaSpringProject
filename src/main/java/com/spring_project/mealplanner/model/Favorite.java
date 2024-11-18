package com.spring_project.mealplanner.model;

public class Favorite {
    private Long userId;
    private Long recipeId;

    // Constructor
    public Favorite(Long userId, Long recipeId) {
        this.userId = userId;
        this.recipeId = recipeId;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}