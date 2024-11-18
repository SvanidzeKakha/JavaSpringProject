package com.spring_project.mealplanner.controller;

import com.spring_project.mealplanner.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private List<Recipe> recipes = new ArrayList<>();

    // DELETE endpoint to delete a recipe (only accessible to admin)
    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        Iterator<Recipe> iterator = recipes.iterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getId().equals(id)) {
                iterator.remove();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}