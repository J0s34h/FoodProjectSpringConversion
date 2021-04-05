package ru.kpfu.itis.group907.fayzullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group907.fayzullin.model.Image;
import ru.kpfu.itis.group907.fayzullin.model.Recipe;
import ru.kpfu.itis.group907.fayzullin.repository.ImageRepository;
import ru.kpfu.itis.group907.fayzullin.repository.RecipeRepository;
import ru.kpfu.itis.group907.fayzullin.service.ImageService;
import ru.kpfu.itis.group907.fayzullin.service.RecipeService;

import java.util.List;

@Controller
public class MainController {

    private final RecipeRepository RecipeRepository;
    private final ImageRepository imageRepository;

    private final RecipeService recipeService;
    private final ImageService imageService;

    static final int totalItemsOnPage = 2;

    @Autowired
    public MainController(ru.kpfu.itis.group907.fayzullin.repository.RecipeRepository recipeRepository, ImageRepository imageRepository, RecipeService recipeService, ImageService imageService) {
        RecipeRepository = recipeRepository;
        this.imageRepository = imageRepository;
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String getNotes(Model model, @RequestParam(value = "page", defaultValue = "0") int pageNumber) {
        List<Recipe> recipes = recipeService.getRecords(pageNumber, totalItemsOnPage);

        for (Recipe recipe : recipes) {
            List<Image> images = imageService.findByRecipeId(recipe.getId());
            if (!images.isEmpty()) {
                recipe.setThumbnail(images.get(0).getPath());
            }
        }

        model.addAttribute("recipes", recipes);



        return "index";
    }


}
