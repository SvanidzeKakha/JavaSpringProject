package com.spring_project.mealplanner.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MealPlanReminderScheduler {

    // This method will run once every week
    @Scheduled(cron = "0 0 9 * * MON") // Runs every Monday at 9:00 AM
    public void sendWeeklyMealPlanReminder() {
        System.out.println("Sending weekly meal plan reminder to users...");
    }
}