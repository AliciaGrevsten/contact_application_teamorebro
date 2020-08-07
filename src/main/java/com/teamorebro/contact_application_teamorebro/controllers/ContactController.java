package com.teamorebro.contact_application_teamorebro.controllers;

import com.teamorebro.contact_application_teamorebro.ContactApplicationTeamorebroApplication;
import com.teamorebro.contact_application_teamorebro.models.Contact;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ContactController {

  /*  @GetMapping("/search")
    public void searchContact(@RequestParam(value="searchword") String searchword, Model model) {
        ArrayList<Contact> matchingContacts = ContactApplicationTeamorebroApplication.searchContacts(searchword);
        model.addAttribute("contacts", matchingContacts);
        for (Contact c: matchingContacts) {
            System.out.println(c.getContactName());
        }
    }*/
    @GetMapping("/findContact")
    public static Contact findContactById(@RequestParam(value="Id") int id) {
        return ContactApplicationTeamorebroApplication.fetchContact(id);
    }

    @PostMapping("/addContact")
    public void addContact(HttpServletResponse response, @RequestParam() String contactName, String mail, String phonenumber )  throws IOException {
        Contact contact = new Contact(contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.addContact(contact);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/editContact", method ={RequestMethod.PUT, RequestMethod.GET})
    public void editContact(HttpServletResponse response, @RequestParam() int id, String contactName, String mail, String phonenumber )  throws IOException {
        Contact contact = new Contact(id, contactName, mail, phonenumber);
        ContactApplicationTeamorebroApplication.editContact(contact);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/delete", method ={RequestMethod.DELETE, RequestMethod.GET})
    public void deleteContact(HttpServletResponse response, @RequestParam int id) throws IOException {
        ContactApplicationTeamorebroApplication.deleteContact(id);
        response.sendRedirect("/");
    }


}
