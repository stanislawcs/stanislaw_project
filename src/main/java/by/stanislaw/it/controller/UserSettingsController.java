package by.stanislaw.it.controller;

import by.stanislaw.it.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@SessionAttributes({"userId", "image"})

public class UserSettingsController {

    @Autowired
    private UserService userService;

    @GetMapping("/settings/user")
    public String showSettingsPageForUSer() {
        return "user_settings_page";
    }

    @SneakyThrows
    @PostMapping("/add-photo/user")
    public String savePhoto(@RequestParam("image") MultipartFile multipartFile, Model model) {
        Path path1 = Paths.get("src", "main", "webapp", "user-images", multipartFile.getOriginalFilename());
        multipartFile.transferTo(path1);
        userService.updateUserPathToImage("user-images/" + multipartFile.getOriginalFilename(),
                String.valueOf(model.getAttribute("userId")));
        return "user_settings_page";

    }
}
