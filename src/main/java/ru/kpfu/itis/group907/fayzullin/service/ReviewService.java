package ru.kpfu.itis.group907.fayzullin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group907.fayzullin.model.Review;
import ru.kpfu.itis.group907.fayzullin.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review findById(int id) {
        return reviewRepository.findById(id);
    }

    public List<Review> findByRecipeId(int recipeId) {
        return reviewRepository.findByRecipeId(recipeId);
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
