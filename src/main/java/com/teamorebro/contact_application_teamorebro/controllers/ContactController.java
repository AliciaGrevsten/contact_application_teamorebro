package com.teamorebro.contact_application_teamorebro.controllers;

import com.teamorebro.contact_application_teamorebro.ContactApplicationTeamorebroApplication;
import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    /*@GetMapping("/contact")
    public static Contact findContact(@RequestParam(value="Id") int Id ) {
        return ContactApplicationTeamorebroApplication.fetchContact(Id);
    }*/

    @GetMapping("/contact")
    public static void addContact(@RequestParam(value="Contact") Contact contact ) {
        ContactApplicationTeamorebroApplication.addContact(contact);
    }




}
