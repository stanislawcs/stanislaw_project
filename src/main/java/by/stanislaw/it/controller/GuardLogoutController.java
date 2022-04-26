package by.stanislaw.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"guardId", "role"})
public class GuardLogoutController {

    @GetMapping("/logout")
    public String logoutButton(SessionStatus sessionStatus) {

        sessionStatus.setComplete();
        return "redirect:/";
    }
}
