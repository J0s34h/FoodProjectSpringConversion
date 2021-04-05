package ru.kpfu.itis.group907.fayzullin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group907.fayzullin.helpers.ImageHelper;
import ru.kpfu.itis.group907.fayzullin.model.Recipe;
import ru.kpfu.itis.group907.fayzullin.model.User;
import ru.kpfu.itis.group907.fayzullin.repository.UserRepository;
import ru.kpfu.itis.group907.fayzullin.service.RecipeService;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class RecipeController {
    private final UserRepository userRepository;
    private final RecipeService recipeService;


    @Autowired
    public RecipeController(UserRepository userRepository, RecipeService recipeService) {
        this.userRepository = userRepository;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public String recipe() {
        return "recipe";
    }

    @PostMapping("/recipe")
    public void uploadSingleFile(String text, String title, @RequestParam("file") List<Part> file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Recipe recipe = new Recipe();
        User user = userRepository.findUserByEmail(auth.getName());

        recipe.setRecipeOwner(user.getId());
        recipe.setText(text);
        recipe.setTitle(title);

        recipe.setThumbnail(file.stream().findFirst().get().getSubmittedFileName());
        recipeService.save(recipe);

        ImageHelper helper = new ImageHelper();

        try {
            helper.saveImagesFrom(file, recipe.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/image/{postId}/{imageName}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getThumbnailImage(@PathVariable int postId, @PathVariable String imageName) throws IOException {

        ImageHelper helper = new ImageHelper();

        List<File> images = helper.getImagesFor(postId);

        AtomicReference<Path> path = new AtomicReference<Path>(Paths.get(images.stream().findFirst().get().getAbsolutePath()));

        images.forEach((image) -> {
            if (image.getName().equals(imageName)) {
                path.set(Paths.get(image.getAbsolutePath()));
            }
        });

        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(
                path.get()
        ));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);

    }
}
