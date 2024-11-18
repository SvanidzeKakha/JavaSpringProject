package com.spring_project.mealplanner.service;

import com.spring_project.mealplanner.model.Favorite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteService {

    private List<Favorite> favorites = new ArrayList<>();

    public Favorite addFavorite(Favorite favorite) {
        favorites.add(favorite);
        return favorite;
    }

    public List<Favorite> getFavoritesByUserId(Long userId) {
        List<Favorite> userFavorites = new ArrayList<>();
        for (Favorite favorite : favorites) {
            if (favorite.getUserId().equals(userId)) {
                userFavorites.add(favorite);
            }
        }
        return userFavorites;
    }

    public boolean removeFavorite(Long userId, Long recipeId) {
        return favorites.removeIf(favorite -> favorite.getUserId().equals(userId) && favorite.getRecipeId().equals(recipeId));
    }
}