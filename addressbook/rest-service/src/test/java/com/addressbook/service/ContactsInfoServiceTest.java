package com.addressbook.service;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;
import com.addressbook.model.ContactInfo;
import com.addressbook.model.PhoneNumbers;
import com.addressbook.rest.repository.AddressbookRepository;
import com.addressbook.rest.repository.ContactRepository;
import com.addressbook.rest.repository.PhoneNumbersRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
@DataJpaTest
public class ContactsInfoServiceTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContactRepository contactrepository;
    @Autowired
    private AddressbookRepository addressRepository;

    @Autowired
    private PhoneNumbersRepository phoneNumbersRepository;

    private ContactsInfoService contactsInfoService;



    @Before
    @Transactional
    public void setup() throws Exception {
        contactsInfoService = new ContactsInfoService();
        entityManager.persist(new Contact(1, "Sam", "Mueir","HR", "sam.m@email.com" ));
        entityManager.persist(new PhoneNumbers(1, "2345667", "home", 1));
        entityManager.persist(new AddressBook("android", "1,"));

    }

    @Test
    public void testGetContacts() throws Exception {
        List<ContactInfo> contacts = contactsInfoService.getContacts("iphone");
        Assert.assertEquals(contacts.size(), 3);

    }


}