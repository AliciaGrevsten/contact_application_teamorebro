package com.teamorebro.contact_application_teamorebro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @GetMapping("/")
    public String getContacts() {

        return "";
    }

    @GetMapping("/search")
    public String searchContact(@RequestParam(name="input", required = false, defaultValue = "") String searchInput, Model model) {

        return "";
    }
}
