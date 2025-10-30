package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.regex.*;

@RestController
public class ValidationController {

    @PostMapping("/password-quality")
    public String checkPasswordQuality(@RequestBody String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[@#$%^&+=!].*")) score++;

        switch (score) {
            case 5: return "Very Strong";
            case 4: return "Strong";
            case 3: return "Moderate";
            case 2: return "Weak";
            default: return "Very Weak";
        }
    }

    @PostMapping("/email-address-valid")
    public boolean validateEmail(@RequestBody(required = false) String email) {
        if (email == null) {
            return false;
        }

        email = java.net.URLDecoder.decode(email, java.nio.charset.StandardCharsets.UTF_8);
        email = email.trim().replaceAll("[\"=]", "").replaceAll("\n", "");

        System.out.println("FINAL EMAIL INPUT: [" + email + "]");

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }


}
