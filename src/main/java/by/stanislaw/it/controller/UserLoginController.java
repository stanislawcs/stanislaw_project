package by.stanislaw.it.controller;

import by.stanislaw.it.entity.User;
import by.stanislaw.it.service.UserService;
import by.stanislaw.it.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes({"userId", "role"})
public class UserLoginController {

    private UserService userService;
    private UserValidation userValidation;

    @Autowired
    public UserLoginController(UserService userService, UserValidation userValidation) {
        this.userService = userService;
        this.userValidation = userValidation;
    }

    @GetMapping("/login/user")
    public String showUserLoginData() {

        return "user_login_page";
    }

    @PostMapping("/login/user")
    public String inputUserLoginData(Model model,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password) {

        String message = userValidation.validateUserLoginData(username, password);

        if (!message.isEmpty()) {
            model.addAttribute("messages", message);
            return "user_login_page";
        } else {
            Optional<User> userlist = userService.getUserByUsername(username);
            model.addAttribute("userId", userlist.get().getId());
            model.addAttribute("role", userlist.get().getRole());
            return "redirect:/user/" + userlist.get().getId();
        }
    }


}
