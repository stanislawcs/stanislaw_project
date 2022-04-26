package by.stanislaw.it.controller;

import by.stanislaw.it.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GuardSearchController {

    @Autowired
    private GuardService guardService;


    @PostMapping("/guards")
    public String searchUsers(@RequestParam("search") String search, Model model) {
        model.addAttribute("guardsList", guardService.searchSecurityGuardNameByInputText(search));
        return "guards";
    }
}