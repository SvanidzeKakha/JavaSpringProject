package com.spring_project.mealplanner.service;

import com.spring_project.mealplanner.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Recipe getRecipeById(Long id) {
        return recipes.stream()
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Recipe addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = getRecipeById(id);
        if (existingRecipe != null) {
            existingRecipe.setTitle(updatedRecipe.getTitle());
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            existingRecipe.setInstructions(updatedRecipe.getInstructions());
        }
        return existingRecipe;
    }

    public boolean deleteRecipe(Long id) {
        return recipes.removeIf(recipe -> recipe.getId().equals(id));
    }
}