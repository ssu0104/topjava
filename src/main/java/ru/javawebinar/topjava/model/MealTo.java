package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MealTo {
    private LocalDateTime dateTime;

    private String description;

    private int calories;
    //
    private boolean excess;

    private int id;

    public MealTo(LocalDateTime dateTime, String description, int calories, int id, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
        this.excess = excess;
    }

    @Override
    public String toString() {
        return "MealTo{" + "dateTime=" + dateTime + ", description='" + description + '\'' + ", calories=" + calories +
                ", excess=" + excess + '}';
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateFormatterTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExcess() {
        return excess;
    }

    public void setExcess(Boolean excess) {
        this.excess = excess;
    }
}
