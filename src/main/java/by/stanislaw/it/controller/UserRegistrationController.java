package by.stanislaw.it.controller;

import by.stanislaw.it.enums.RoleEnums;
import by.stanislaw.it.service.UserService;
import by.stanislaw.it.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId","role"})
public class UserRegistrationController {

    private UserService userService;
    private UserValidation userValidation;



    @Autowired
    public UserRegistrationController(UserService userService, UserValidation userValidation) {
        this.userService = userService;
        this.userValidation = userValidation;
    }



    @GetMapping("/registration/user")
    public String RegistrationDataForUser() {
        return "user_register_page";
    }

    @PostMapping("/registration/user")
    public String inputRegistrationData(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("repassword") String repassword, Model model) {
        String message = userValidation.validateUserRegistrationData(username, password, repassword);
         if(!message.isEmpty()){
             model.addAttribute("messages",message);
             return "user_register_page";
         }
         else {
             userService.save(username,password,RoleEnums.USER.name());
             return "redirect:/login/user";
         }
    }
}
