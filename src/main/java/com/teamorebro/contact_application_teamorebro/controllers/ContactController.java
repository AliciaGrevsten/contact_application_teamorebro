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
        return ContactApplicationTeamorebroApplication.fetchContact(id);
    }

    @PostMapping("/addContact")
    public String addContact(@RequestParam() String contactName, String mail, String phonenumber ) {
        Contact contact = new Contact(contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.addContact(contact);
        return "redirect:/index";
    }

    @RequestMapping(value = "/editContact", method ={RequestMethod.PUT, RequestMethod.GET})
    public String editContact(@RequestParam() int id, String contactName, String mail, String phonenumber ) {
        Contact contact = new Contact(id, contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.editContact(contact);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
    public String deleteContact(@RequestParam int id) {
        ContactApplicationTeamorebroApplication.deleteContact(id);
        return "redirect:/index";
    }
}
