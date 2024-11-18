package com.spring_project.mealplanner.controller;

import com.spring_project.mealplanner.model.Favorite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring_project.mealplanner.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    private List<Favorite> favorites = new ArrayList<>();

    @DeleteMapping("/{userId}/{recipeId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long userId, @PathVariable Long recipeId) {
        boolean removed = favoriteService.removeFavorite(userId, recipeId);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // POST endpoint to mark a recipe as favorite for a user
    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        favorites.add(favorite);
        return new ResponseEntity<>(favorite, HttpStatus.CREATED);
    }

    // GET endpoint to fetch all favorite recipes for a specific user
    @GetMapping("/{userId}")
    public ResponseEntity<List<Favorite>> getFavoritesByUser(@PathVariable Long userId) {
        List<Favorite> userFavorites = favorites.stream()
                .filter(fav -> fav.getUserId().equals(userId))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userFavorites, HttpStatus.OK);
    }
}