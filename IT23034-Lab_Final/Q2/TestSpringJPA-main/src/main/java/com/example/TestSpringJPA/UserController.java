package com.example.TestSpringJPA;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // READ: List all students
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<Student> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    // INSERT: Handle new student form submission
    @PostMapping("/users")
    public String addUser(@ModelAttribute Student user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    // DELETE: Delete a student by ID
    @PostMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    // UPDATE (Step 2): Handle form submission
    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute Student user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Student user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

}

