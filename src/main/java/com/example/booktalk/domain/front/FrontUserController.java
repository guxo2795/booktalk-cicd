package com.example.booktalk.domain.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontUserController {

    @GetMapping("/booktalk/users/profile")
    public String myProfilePage() {
        return "profile";
    }

    @GetMapping("/booktalk/users/{userId}/profile")
    public String otherProfilePage(@PathVariable Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "otherProfile";
    }

}
