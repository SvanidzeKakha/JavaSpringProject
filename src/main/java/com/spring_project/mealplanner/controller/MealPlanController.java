package com.spring_project.mealplanner.controller;

import com.spring_project.mealplanner.model.MealPlan;
import com.spring_project.mealplanner.service.MealPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/meal-plans")
public class MealPlanController {

    @Autowired
    private MealPlanService mealPlanService;
    private List<MealPlan> mealPlans = new ArrayList<>();

    // POST endpoint to create a new meal plan
    @PostMapping
    public ResponseEntity<MealPlan> createMealPlan(@RequestBody MealPlan mealPlan) {
        mealPlans.add(mealPlan);
        return new ResponseEntity<>(mealPlan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealPlan> updateMealPlan(@PathVariable Long id, @RequestBody MealPlan updatedMealPlan) {
        MealPlan mealPlan = mealPlanService.updateMealPlan(id, updatedMealPlan);
        return mealPlan != null ? ResponseEntity.ok(mealPlan) : ResponseEntity.notFound().build();
    }

    // GET endpoint to get meal plan details for a specific user
    @GetMapping("/{userId}")
    public ResponseEntity<List<MealPlan>> getMealPlansByUser(@PathVariable Long userId) {
        List<MealPlan> userMealPlans = new ArrayList<>();
        for (MealPlan plan : mealPlans) {
            if (plan.getUserId().equals(userId)) {
                userMealPlans.add(plan);
            }
        }
        return new ResponseEntity<>(userMealPlans, HttpStatus.OK);
    }
}