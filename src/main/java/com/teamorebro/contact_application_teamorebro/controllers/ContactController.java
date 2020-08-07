package com.teamorebro.contact_application_teamorebro.controllers;

import com.teamorebro.contact_application_teamorebro.ContactApplicationTeamorebroApplication;
import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContactController {

    @GetMapping("/search")
    public void searchContact(@RequestParam(value="searchword") String searchword, Model model) {
        ArrayList<Contact> matchingContacts = ContactApplicationTeamorebroApplication.searchContacts(searchword);
        model.addAttribute("contacts", matchingContacts);
        for (Contact c: matchingContacts) {
            System.out.println(c.getContactName());
        }
    }
    @GetMapping("/findContact")
    public static Contact findContactById(@RequestParam(value="Id") int id) {
        Contact contact = ContactApplicationTeamorebroApplication.fetchContact(id);
        return contact;
    }

    @PostMapping("/addContact")
    public void addContact(@RequestParam() String contactName, String mail, String phonenumber ) {
        Contact contact = new Contact(contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.addContact(contact);
    }

    @PutMapping("/editContact")
    public void editContact(@RequestParam() int id, String contactName, String mail, String phonenumber ) {
        Contact contact = new Contact(id, contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.addContact(contact);
    }

    @DeleteMapping("/deleteContact")
    public void deleteContact(@RequestParam int Id) {
        ContactApplicationTeamorebroApplication.deleteContact(Id);
    }
}
