package com.kma.practice8.springsecuritycustom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kma.practice8.springsecuritycustom.domain.security.MyCustomUserDetails;

@Controller
@PreAuthorize("isFullyAuthenticated()")
public class UserController {

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/user-details")
    public ResponseEntity<MyCustomUserDetails> userDetails() {
        final MyCustomUserDetails userDetails = (MyCustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDetails);
    }

}
