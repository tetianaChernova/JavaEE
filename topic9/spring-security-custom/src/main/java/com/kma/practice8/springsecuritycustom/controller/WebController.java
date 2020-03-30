package com.kma.practice8.springsecuritycustom.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "admin_root";
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @GetMapping("/admin/subpage")
    public String adminSubpage() {
        return "admin_sub";
    }

    @PreAuthorize("hasAuthority('VIEW_CATALOG')")
    @GetMapping("/catalog")
    public String catalog() {
        return "catalog";
    }

    @GetMapping("/other")
    public String other() {
        return "other";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
