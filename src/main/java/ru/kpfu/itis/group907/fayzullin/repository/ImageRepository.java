package ru.kpfu.itis.group907.fayzullin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.group907.fayzullin.model.Image;
import ru.kpfu.itis.group907.fayzullin.model.Recipe;

import javax.persistence.Table;
import java.util.List;

@Table(catalog = "image")
public interface ImageRepository extends CrudRepository<Recipe, Integer> {

    @Query(value = "SELECT * FROM image WHERE recipe_id = ?1", nativeQuery = true)
    List<Image> findByRecipeId(int recipeId);
}
