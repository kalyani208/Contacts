package com.addressbook.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.addressbook.model.Contact;
import com.addressbook.service.ContactService;
//creating RestController
@RestController
public class ContactController
{
    //autowired the StudentService class
    @Autowired
    ContactService contactService;
    //creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/contact")
    private List<Contact> getAllContacts()
    {
        return contactService.getAllContact();
    }
    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/conact/{id}")
    private Contact getContact(@PathVariable("id") int id)
    {
        return contactService.getContactById(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/contact")
    private int saveContact(@RequestBody Contact contact)
    {
        contactService.saveOrUpdate(contact);
        return contact.getContactid();
    }
}