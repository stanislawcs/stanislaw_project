package by.stanislaw.it.controller;

import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.enums.RoleEnums;
import by.stanislaw.it.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"guardId", "role"})
public class AdminController {
    @Autowired
    private GuardService guardService;

    @GetMapping("/admin")
    public String showAdminPanel(Model model) {

        ArrayList<SecurityGuard> guardsList = (ArrayList<SecurityGuard>)
                guardService.
                        getAllGuards().
                        stream().filter(i -> !i.getPassportNumber().equals("ADMIN")).collect(Collectors.toList());

        model.addAttribute("guardsList", guardsList);
        return "admin_page";
    }

    @GetMapping("/admin/add-guard")
    public String showAddUserPage() {
        return "add_guard_page";
    }

    @PostMapping("/admin/add-guard")
    public String saveNewGuard(@RequestParam("name") String name) {
        String refactoredName = "demo" + name;
        guardService.save(refactoredName, "000","000", RoleEnums.GUARD.name());
        return "add_guard_page";
    }

    @PostMapping("/admin-action")
    public String getAdminActionButtonValue(@RequestParam("adminActionButton") String buttonValue) {
        String[] splittedButtonValues = buttonValue.split("\\s");
        checkAndTakeAdminAction(splittedButtonValues[0], splittedButtonValues[1]);
        return "redirect:/admin";
    }

    private void checkAndTakeAdminAction(String action, String id) {
        switch (action) {
            case "DELETE":
                guardService.deleteGuardById(id);
                break;
        }
    }
}