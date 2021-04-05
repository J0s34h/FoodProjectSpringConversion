package ru.kpfu.itis.group907.fayzullin.model;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(nullable = false)
    private byte rating;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int recipeId;

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getId() {
        return id;
    }

    public byte getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    public int getRecipeId() {
        return recipeId;
    }
}
