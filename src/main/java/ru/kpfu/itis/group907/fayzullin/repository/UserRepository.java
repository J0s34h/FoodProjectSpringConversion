package ru.kpfu.itis.group907.fayzullin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.group907.fayzullin.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    @Query(value = "SELECT * FROM app_user WHERE email = ?1", nativeQuery = true)
    List<User> findAllByEmail(String email);

    // used for pagination
    Page<User> findAll(Pageable pageable);

    @Query(value = "select * from app_user u where u.name = ?1", nativeQuery = true)
    User findUserByName(String name);

    @Query(value = "SELECT * FROM app_user", nativeQuery = true)
    List<User> getAll();
}

