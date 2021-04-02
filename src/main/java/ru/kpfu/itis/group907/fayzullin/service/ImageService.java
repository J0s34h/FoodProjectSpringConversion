package ru.kpfu.itis.group907.fayzullin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group907.fayzullin.model.Image;
import ru.kpfu.itis.group907.fayzullin.repository.ImageRepository;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> findByRecipeId(int id) {
        return imageRepository.findByRecipeId(id);
    }
}
