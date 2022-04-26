package by.stanislaw.it.controller;

import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.service.GuardService;
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
@SessionAttributes({"guardId", "role"})
public class HomeController {
    @Autowired
    private GuardService guardService;


    @GetMapping("/guard/{id}")
    public String showHomePageData(@PathVariable("id") String id, Model model) {
        Optional<SecurityGuard> securityGuard = guardService.getSecurityGuardById(id);

        if (securityGuard.isPresent()) {
            String flag = "ThisIsMainGuard";
            if (checkIfThisMainGuard(id, model.getAttribute("guardId").toString())) {
                model.addAttribute(flag, true);

            } else {
                model.addAttribute(flag, false);
            }
            model.addAttribute("img", securityGuard.get().getPathToGuardImage());
            model.addAttribute("name", securityGuard.get().getName());


        } else {
            return "redirect:/registration";
        }
        return "home_page";
    }

    @GetMapping("/guards")
    public String showAllGuards(Model model) {
        ArrayList<SecurityGuard> guardsList = (ArrayList<SecurityGuard>)
                guardService.
                        getAllGuards().
                        stream().filter(i -> !i.getPassportNumber().equals("ADMIN")).collect(Collectors.toList());

        model.addAttribute("guardsList", guardsList);
        return "guards";
    }

    private boolean checkIfThisMainGuard(String pathId, String currentId) {
        return pathId.equals(currentId);
    }

    @GetMapping("/objects")
    public String showAllObjects() {
        return "objects";
    }
}
