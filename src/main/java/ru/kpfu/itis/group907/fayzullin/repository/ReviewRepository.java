package ru.kpfu.itis.group907.fayzullin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.group907.fayzullin.model.Review;

import javax.persistence.Table;
import java.util.List;

@Table(catalog = "review")
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    @Query(value = "SELECT * FROM review WHERE id = ?1", nativeQuery = true)
    Review findById(int id);

    @Query(value = "SELECT * FROM review where recipe_id = ?1", nativeQuery = true)
    List<Review> findByRecipeId(int recipeId);
}
