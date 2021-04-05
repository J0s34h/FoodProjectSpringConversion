package ru.kpfu.itis.group907.fayzullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.group907.fayzullin.helpers.ImageHelper;
import ru.kpfu.itis.group907.fayzullin.model.Recipe;
import ru.kpfu.itis.group907.fayzullin.model.Review;
import ru.kpfu.itis.group907.fayzullin.model.User;
import ru.kpfu.itis.group907.fayzullin.repository.UserRepository;
import ru.kpfu.itis.group907.fayzullin.service.RecipeService;
import ru.kpfu.itis.group907.fayzullin.service.ReviewService;

import java.io.File;
import java.util.List;

@Controller
public class ReviewController {
    private final RecipeService recipeService;
    private final ReviewService reviewService;

    private final ImageHelper imageHelper;
    private final UserRepository userRepository;

    @Autowired
    public ReviewController(RecipeService recipeService, ReviewService reviewService, UserRepository userRepository) {
        this.recipeService = recipeService;
        this.reviewService = reviewService;
        this.userRepository = userRepository;
        this.imageHelper = new ImageHelper();
    }

    @GetMapping("/review")
    public String getReview(Model model, @RequestParam(value = "id", defaultValue = "1") int reviewId) {
        Recipe recipe = recipeService.findByID(reviewId);
        List<File> images = imageHelper.getImagesFor(recipe.getId());
        List<Review> reviews = reviewService.findByRecipeId(recipe.getId());

        model.addAttribute("recipe", recipe);
        model.addAttribute("images", images);
        model.addAttribute("reviews", reviews);

        return "review";
    }

    @PostMapping(value="/createReview")
    @ResponseBody
    public String postReview(int rating, String message, int recipeId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Review review = new Review();

        Recipe recipe = recipeService.findByID(recipeId);
        User user = userRepository.findUserByEmail(auth.getName());

        review.setMessage(message);
        review.setRating((byte) rating);
        review.setRecipeId(recipe.getId());
        review.setUserId(user.getId());

        reviewService.save(review);

        return "TRUE";
    }
}
