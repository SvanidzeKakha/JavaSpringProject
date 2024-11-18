package com.spring_project.mealplanner.service;

import com.spring_project.mealplanner.model.MealPlan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealPlanService {

    private List<MealPlan> mealPlans = new ArrayList<>();

    public MealPlan createMealPlan(MealPlan mealPlan) {
        mealPlans.add(mealPlan);
        return mealPlan;
    }

    public List<MealPlan> getMealPlansByUserId(Long userId) {
        List<MealPlan> userMealPlans = new ArrayList<>();
        for (MealPlan mealPlan : mealPlans) {
            if (mealPlan.getUserId().equals(userId)) {
                userMealPlans.add(mealPlan);
            }
        }
        return userMealPlans;
    }

    public MealPlan updateMealPlan(Long id, MealPlan updatedMealPlan) {
        for (MealPlan mealPlan : mealPlans) {
            if (mealPlan.getId().equals(id)) {
                mealPlan.setRecipes(updatedMealPlan.getRecipes());
                mealPlan.setWeekOf(updatedMealPlan.getWeekOf());
                return mealPlan;
            }
        }
        return null;
    }

    public boolean deleteMealPlan(Long id) {
        return mealPlans.removeIf(mealPlan -> mealPlan.getId().equals(id));
    }
}