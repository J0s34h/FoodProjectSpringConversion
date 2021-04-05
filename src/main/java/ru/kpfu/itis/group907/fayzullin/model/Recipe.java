package ru.kpfu.itis.group907.fayzullin.model;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(nullable = false)
    private int recipeOwner;

    @Column(nullable = false)
    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public void setRecipeOwner(int recipeOwner) {
        this.recipeOwner = recipeOwner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String thumbnail = "placeholder";

    public int getId() {
        return id;
    }

    public int getRecipeOwner() {
        return recipeOwner;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}