package by.stanislaw.it.controller;

import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.entity.User;
import by.stanislaw.it.service.GuardService;
import by.stanislaw.it.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"userId", "role","guardId"})
public class UserHomeController {

    private UserService userService;
    private GuardService guardService;

    @Autowired
    public UserHomeController(UserService userService, GuardService guardService) {
        this.userService = userService;
        this.guardService = guardService;
    }

    @GetMapping("/user/{id}")
    public String showUserHomePage(@PathVariable("id") String id, Model model) {
        Optional<User> users = userService.getUserById(id);

        String flag = "ThisIsYou";
        if (users.isPresent()) {
            if (thisIsRightUser(id, model.getAttribute("userId").toString())) {

                model.addAttribute(flag, true);
            } else
                model.addAttribute(flag, false);
            model.addAttribute("image",users.get().getPathToImage());
            model.addAttribute("username",users.get().getUsername());
        } else
            return "redirect:/registration/user";

        return "user_home_page";

    }

    private boolean thisIsRightUser(String pathId, String currentId) {
        return pathId.equals(currentId);
    }

    @GetMapping("/guards/user")
    public String showAllGuardsOnUserHomePage(Model model) {
        ArrayList<SecurityGuard> guardsList = (ArrayList<SecurityGuard>)
                guardService.
                        getAllGuards().
                        stream().filter(i -> !i.getPassportNumber().equals("ADMIN")).collect(Collectors.toList());

        model.addAttribute("guardsList", guardsList);
        return "user_guards";
    }


}

