package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @GetMapping("/create")
    public String createUser(@ModelAttribute(name = "user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/update";
    }

    @PostMapping("/update")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
