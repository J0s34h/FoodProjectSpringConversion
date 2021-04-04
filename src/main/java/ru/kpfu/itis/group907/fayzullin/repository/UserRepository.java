package ru.kpfu.itis.group907.fayzullin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.group907.fayzullin.model.User;

import javax.persistence.Table;
import java.util.List;

@Table(catalog = "app_user")
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "select * from app_user u where u.name = ?1", nativeQuery = true)
    User findUserByName(String name);

    @Query(value = "select * from app_user u where u.email = ?1", nativeQuery = true)
    User findUserByEmail(String name);

    @Query(value = "SELECT * FROM app_user", nativeQuery = true)
    List<User> getAll();
}

