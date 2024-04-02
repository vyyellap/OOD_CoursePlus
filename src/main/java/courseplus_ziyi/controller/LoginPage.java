package courseplus_ziyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPage {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        // Add your login logic here, such as validating credentials
        // and redirecting the user based on the result.
        // For simplicity, let's assume successful login redirects to home page.
        return "redirect:/";
    }
}
