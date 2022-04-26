package by.stanislaw.it.validation;

import by.stanislaw.it.encoder.PasswordEncoder;
import by.stanislaw.it.entity.User;
import by.stanislaw.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidation {

    @Autowired
    private UserService userService;

    public String validateUserLoginData(String username, String password) {
        String message = "";

        Optional<User> users = userService.getUserByUsername(username);

        if (!users.isPresent()) {
            message = "user not found";
        } else if (!users.get().getPassword().equals(PasswordEncoder.encodePassword(password))) {
            message = "Incorrect password";
        }
        return message;
    }

    public String validateUserRegistrationData(String username, String password, String repassword) {
        String message = "";

        if (userService.getUserByUsername(username).isPresent()) {
            message = "User already exist";

        } else if (!password.equals(repassword)) {
            message = "passwords mismatch";
        }
        else if(!userService.getUserByUsername(username).isEmpty()){
            message = "Your name is null";
        }
        return message;
    }

}
