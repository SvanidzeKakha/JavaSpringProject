package com.spring_project.mealplanner.model;

import java.util.List;

public class MealPlan {

    private Long id;
    private Long userId;
    private List<Long> recipes;
    private String weekOf;

    // Constructor, getters, and setters

    public MealPlan(Long id, Long userId, List<Long> recipes, String weekOf) {
        this.id = id;
        this.userId = userId;
        this.recipes = recipes;
        this.weekOf = weekOf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Long> recipes) {
        this.recipes = recipes;
    }

    public String getWeekOf() {
        return weekOf;
    }

    public void setWeekOf(String weekOf) {
        this.weekOf = weekOf;
    }
}