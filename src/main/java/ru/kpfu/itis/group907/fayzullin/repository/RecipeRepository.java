package ru.kpfu.itis.group907.fayzullin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group907.fayzullin.model.Recipe;

import javax.persistence.Table;
import java.util.List;

@Table(catalog = "recipe")
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    @Query(value = "SELECT * FROM recipe WHERE id = ?1", nativeQuery = true)
    Recipe findById(int id);

    @Query(value = "SELECT * FROM recipe", nativeQuery = true)
    List<Recipe> findAll();

    @Query(value = "SELECT * FROM recipe ORDER BY Id OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY", nativeQuery = true)
    List<Recipe> getRecords(int page, int total);
}