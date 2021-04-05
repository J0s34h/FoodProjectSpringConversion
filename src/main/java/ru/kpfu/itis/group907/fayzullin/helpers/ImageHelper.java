package ru.kpfu.itis.group907.fayzullin.helpers;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageHelper {
    String UPLOAD_LOCATION = System.getProperty("user.home") + "/Develop/Java/Spring/FoodProjectSpringConversion/src/main/resources/";

    public void saveImagesFrom(List<Part> fileParts, int postId) throws IOException {
        for (Part filePart : fileParts) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();

            try {
                File uploads = new File(UPLOAD_LOCATION + postId);

                if (!uploads.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    uploads.mkdir();
                    // If you require it to make the entire directory path including parents,
                    // use directory.mkdirs(); here instead.
                }

                File file = new File(uploads, fileName);

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath());
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public List<File> getImagesFor(int postId) {
        List<File> imageSet = new ArrayList<File>();
        String postPath = UPLOAD_LOCATION + postId + "/";

        File imagesLocation = new File(postPath);

        if (imagesLocation.exists() && imagesLocation.list() != null) {
            //noinspection ConstantConditions
            for (String fileName : imagesLocation.list()) {
                imageSet.add(new File(postPath + fileName));
            }
        }

        return imageSet;
    }
}
