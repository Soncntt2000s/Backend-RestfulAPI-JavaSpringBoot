package com.projectJava.Hylife.User.Controler;

import com.projectJava.Hylife.User.Entity.UserProfile;
import com.projectJava.Hylife.User.Entity.Users;
import com.projectJava.Hylife.User.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@CrossOrigin("*")
@RestController("/api")
public class UploadImgDBController {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("upload_img")
    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    public UserProfile create(@RequestParam MultipartFile image) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(Objects.requireNonNull(image.getOriginalFilename()));
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
        UserProfile userprofile = new UserProfile();
        userprofile.setUrl_img_avatar(imagePath.resolve(image.getOriginalFilename()).toString());
        return userProfileRepository.save(userprofile);
    }
}
