package com.teamorebro.contact_application_teamorebro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/")
    public String getContacts() {

        return "";
    }
}
