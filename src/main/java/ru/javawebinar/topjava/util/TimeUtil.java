package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class TimeUtil {
    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
    }

    public static int totalCalories(List<UserMeal> userMeals, LocalDate targetDate) {
        int totalCalories = 0;

        for (UserMeal meal : userMeals) {
            LocalDateTime mealDateTime = meal.getDateTime();
            LocalDate localDate = mealDateTime.toLocalDate();

            if (localDate.isEqual(targetDate)) {
                totalCalories += meal.getCalories();

            }
        }

        return totalCalories;
    }

}