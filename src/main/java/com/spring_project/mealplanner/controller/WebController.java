package com.spring_project.mealplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/recipes")
    public String recipesPage() {
        return "recipes"; // This should match templates/recipes.html
    }

    @GetMapping("/favorites")
    public String favoritesPage() {
        return "favorites"; // This should match templates/favorites.html
    }

    @GetMapping("/mealPlans")
    public String mealPlansPage() {
        return "mealPlans"; // This should match templates/mealPlans.html
    }
}
