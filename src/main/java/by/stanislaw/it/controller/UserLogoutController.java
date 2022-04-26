package by.stanislaw.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"userId", "role"})
public class UserLogoutController {

    @GetMapping("/logout/user")
    public String logoutButton(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login/user";

    }
}
