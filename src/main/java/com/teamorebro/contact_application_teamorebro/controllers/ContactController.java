package com.teamorebro.contact_application_teamorebro.controllers;

import com.teamorebro.contact_application_teamorebro.ContactApplicationTeamorebroApplication;
import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ContactController {

    @GetMapping("/search")
    public static void findContact(@RequestParam(value="Id") String searchword, Model model) {
        ArrayList<Contact> matchingContacts = ContactApplicationTeamorebroApplication.searchContacts(searchword);
        model.addAttribute(matchingContacts);
    }

    @PostMapping("/addContact")
    public static void addContact(@RequestParam() String contactName, String mail, String phonenumber ) {
        Contact contact = new Contact(contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.addContact(contact);
    }

}
