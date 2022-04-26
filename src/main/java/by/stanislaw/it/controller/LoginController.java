package by.stanislaw.it.controller;

import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.service.GuardService;
import by.stanislaw.it.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes({"guardId","role"})
public class LoginController {

    private GuardService guardService;
    private Validation validation;

    @Autowired
    public LoginController(GuardService guardService, Validation validation) {
        this.guardService = guardService;
        this.validation = validation;
    }

    @GetMapping({"/", "/login"})
    public String showGuardLoginData() {
        return "login_page";
    }

    @PostMapping("/login")
    public String inputGuardLoginData(@RequestParam("passportNumber") String passportNumber,
                                      @RequestParam("password") String password, Model model) {
        String message = validation.validateLoginData(passportNumber, password);
        if (!message.isEmpty()) {
            model.addAttribute("message", message);
            return "login_page";
        } else {
            Optional<SecurityGuard> guard = guardService.getSecurityGuardByPassportNumber(passportNumber);
            model.addAttribute("guardId", guard.get().getId());
            model.addAttribute("role",guard.get().getRole());
            return "redirect:/guard/" + guard.get().getId();
        }
    }
}
