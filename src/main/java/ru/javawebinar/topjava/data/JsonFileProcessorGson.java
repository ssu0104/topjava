package ru.javawebinar.topjava.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.LocalDateTimeDeserializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonFileProcessorGson {
    private final File jsonFile;
    private final Gson gson;
    private List<Meal> meals;


    public JsonFileProcessorGson(File jsonFile) {
        this.jsonFile = jsonFile;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        this.gson = gsonBuilder.setPrettyPrinting().create();
        loadMeals();
    }

    public void loadMeals() {
        try (FileReader reader = new FileReader(jsonFile)) {
            meals = gson.fromJson(reader, new TypeToken<List<Meal>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
            meals = new ArrayList<Meal>();
        }
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Meal getMealById(int id) {
        for (Meal meal : meals) {
            if (meal.getId() == id) {
                return meal;
            }
        }
        return null;
    }

    public void editMeal(Meal editedMeal) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getId() == editedMeal.getId()) {
                meals.set(i, editedMeal);
                break;
            }
        }
        saveChanges();
    }

    public void addMeal(Meal newMeal) {
        meals.add(newMeal);
        saveChanges();
    }

    private void saveChanges() {
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(meals, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
