package by.stanislaw.it.validation;

import by.stanislaw.it.encoder.PasswordEncoder;
import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validation {
    @Autowired
    private GuardService guardService;

    public String validateLoginData(String passportNumber, String password) {
        String message = "";
        Optional<SecurityGuard> securityGuard = guardService.getSecurityGuardByPassportNumber(passportNumber);
        if (!securityGuard.isPresent()) {
            message = "Guard not found!";
        } else if (!securityGuard.get().getPassword().equals(PasswordEncoder.encodePassword(password))) {
            message = "Incorrect password";
        }
        return message;
    }

    public String validateRegistrationData(String name,String passportNumber, String password, String repassword) {
        String message = "";
        if (guardService.getSecurityGuardByName(name).isPresent()) {
            message = "Guard is xxx";
        }
        if (guardService.getSecurityGuardByPassportNumber(passportNumber).isPresent()) {
            message = "Guard already exist";
        } else if (!password.equals(repassword)) {
            message = "Passwords mismatched";
        }
        return message;
    }
}