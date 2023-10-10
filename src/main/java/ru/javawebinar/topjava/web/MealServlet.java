package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.data.JsonFileProcessorGson;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.MealsUtil.filteredByStreams;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final int caloriesPerDay = 2000;
    private static final LocalTime startTime = LocalTime.of(1, 0);
    private static final LocalTime endTime = LocalTime.of(23, 0);
    private final List<MealTo> listMealTo = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        File jsonFile = new File("C:\\projects\\topjava\\src\\main\\resources\\meals.json");
        JsonFileProcessorGson processor = new JsonFileProcessorGson(jsonFile);
        List<Meal> meals = processor.getMeals();
        List<MealTo> listMealTo = filteredByStreams(meals, startTime, endTime, caloriesPerDay);

        request.setAttribute("listMealTo", listMealTo);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
