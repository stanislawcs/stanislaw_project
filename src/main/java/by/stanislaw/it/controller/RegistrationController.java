package by.stanislaw.it.controller;

import by.stanislaw.it.enums.RoleEnums;
import by.stanislaw.it.service.GuardService;
import by.stanislaw.it.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"guardId","role"})
public class RegistrationController {
    private GuardService guardService;

    private Validation validation;

    @Autowired
    public RegistrationController(GuardService guardService, Validation validation) {
        this.guardService = guardService;
        this.validation = validation;
    }


    @GetMapping("/registration")
    public String registerGuardData() {
        return "register_page";
    }

    @PostMapping("/registration")
    public String postRegisterGuardData(Model model,@RequestParam("name") String name, @RequestParam("passportNumber") String passportNumber,
                                        @RequestParam("password") String password, @RequestParam("repassword") String repassword) {
        String message = validation.validateRegistrationData(name,passportNumber, password, repassword);
        if (!message.isEmpty()) {
            model.addAttribute("message", message);
            return "register_page";
        } else {
            guardService.save(name,passportNumber,password,RoleEnums.GUARD.name());
            return "redirect:/";
        }
    }
}
