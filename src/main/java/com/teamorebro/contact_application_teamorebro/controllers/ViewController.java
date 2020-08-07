package com.teamorebro.contact_application_teamorebro.controllers;

import com.teamorebro.contact_application_teamorebro.ContactApplicationTeamorebroApplication;
import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ViewController {

    @GetMapping("/add")
    public String addNewContact() {
        return "Add";
    }

    @GetMapping("/edit")
    public String editContact(@RequestParam int id, Model model) {
        Contact contact = ContactController.findContactById(id);
        model.addAttribute(contact);
        return "Edit";
    }

    @GetMapping("/")
    public String showContacts(Model model) {
        ContactApplicationTeamorebroApplication.readContacts();
        ArrayList<Contact> contacts = ContactApplicationTeamorebroApplication.readContacts();
        model.addAttribute("contacts", contacts);
        return "index";
    }

    @RequestMapping(value = "/contact/search")
    public String searchedContacts(@RequestParam("word") String word, Model model) {
        ContactApplicationTeamorebroApplication.readContacts();
       // ArrayList<Contact> contacts = ContactApplicationTeamorebroApplication.searchCon(word);
        model.addAttribute("contacts", ContactApplicationTeamorebroApplication.searchCon(word));
        return "index";
    }

}
