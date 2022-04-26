package by.stanislaw.it.controller;

import by.stanislaw.it.service.GuardService;
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
@SessionAttributes({"guardId", "img"})
public class GuardSettingsController {

    @Autowired
    private GuardService guardService;

    @GetMapping("/settings")
    public String showSettingsPageForGuard() {
        return "settings_page";
    }

    @SneakyThrows
    @PostMapping("/add-photo")
    public String savePhotoForGuard(@RequestParam("image") MultipartFile file, Model model) {

        Path path = Paths.get("src", "main", "webapp", "images", file.getOriginalFilename());
        file.transferTo(path);
        guardService.updatePathToGuardImageById("images/" + file.getOriginalFilename(),
                String.valueOf(model.getAttribute("guardId")));

        return "settings_page";

    }

}
