package com.addressbook.service;
import java.util.ArrayList;
import java.util.List;

import com.addressbook.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.addressbook.rest.repository.ContactRepository;
import com.addressbook.rest.repository.PhoneNumbersRepository;
@Service
public class ContactService
{
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    PhoneNumbersRepository PhoneNumbersRepository;
    //getting all student records
    public List<Contact> getAllContact()
    {
        List<Contact> contacts = new ArrayList<Contact>();
        contactRepository.findAll().forEach(contact -> contacts.add(contact));
        return contacts;
    }
    //getting a specific record
    public Contact getContactById(int id)
    {
        return contactRepository.findById(id);
    }
    public void saveOrUpdate(Contact contact)
    {
        contactRepository.save(contact);
    }

}