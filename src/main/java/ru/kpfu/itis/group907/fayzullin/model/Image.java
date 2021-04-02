package ru.kpfu.itis.group907.fayzullin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @NotBlank(message = "Filename shouldn't be blank!")
    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private int recipeId;

    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getPath() {
        return "/images/" + recipeId + "/" + filename;
    }
}

