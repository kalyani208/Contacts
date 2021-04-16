package com.addressbook.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;
import com.addressbook.model.ContactInfo;
import com.addressbook.model.PhoneNumbers;
import com.addressbook.rest.dto.request.ContactRequestDTO;
import com.addressbook.rest.dto.request.DeleteRequestDTO;
import com.addressbook.rest.repository.AddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.addressbook.rest.repository.ContactRepository;
import com.addressbook.rest.repository.PhoneNumbersRepository;
import javax.transaction.Transactional;



@Service
@Transactional
public class ContactsInfoService
{
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    PhoneNumbersRepository phoneNumbersRepository;
    @Autowired
    AddressbookRepository addressbookRepository;
    //getting all student records
    public List<ContactInfo> getContacts(String addressbook)
    {
        List<ContactInfo> contacts = new ArrayList<>();
        String csvcontactIds = addressbookRepository.findByAddressBookId(addressbook).getContactlist();
        //System.out.println("csvcontac"+csvcontactIds);
        List<String> contactIds = Arrays.asList(csvcontactIds.split("\\s*,\\s*"));
        System.out.println("csvcontac"+contactIds);
        contactIds.forEach(contact -> contacts.add(getContactInfo(Integer.parseInt(contact))));
        return contacts;
    }
    public ContactInfo getContactInfo(int contact){
        ContactInfo contactinfo = new ContactInfo();
        contactinfo.setContact(contactRepository.findById(contact));
        contactinfo.setPhoneNumbers(getPhoneNumbers(contact));
        return contactinfo;
    }
    public List<PhoneNumbers> getPhoneNumbers(int contactId){
        List<PhoneNumbers> phoneNumbers = new ArrayList<PhoneNumbers>();
        return phoneNumbersRepository.findAllByContactid(contactId);

    }

    public int addContact(ContactRequestDTO contactInfo)
    {
        Contact contact = new Contact();
        PhoneNumbers phoneNumber = new PhoneNumbers();
        String addressBook = contactInfo.getAddressbook();
        contact.setCompany(contactInfo.getCompany());
        contact.setEmail(contactInfo.getEmail());
        contact.setFirstname(contactInfo.getFirstname());
        contact.setLastname(contactInfo.getLastname());
        phoneNumber.setPhoneNumber(contactInfo.getPhonenumber());
        phoneNumber.setPhoneType(contactInfo.getPhonetype());

        return updateContactInfo(contact,phoneNumber,addressBook);

    }
    @Transactional
    public List<Contact> deleteContact(DeleteRequestDTO contactName)
    {
        String firstname = contactName.getFirstname();
        String lastname = contactName.getLastname();
        int contactid =contactRepository.ContactByName(firstname, lastname);
        phoneNumbersRepository.deleteByContactid(contactid);
        List<Contact> deletedContacts = contactRepository.deleteById(contactid);
        return deletedContacts;

    }

    private int updateContactInfo(Contact contact, PhoneNumbers phoneNumber, String addressbook){
       int contactId =  contactRepository.save(contact).getContactid();
       phoneNumber.setContactid(contactId);
        phoneNumbersRepository.save(phoneNumber);
        updateAddressbook(contactId, addressbook );
        return contactId;

    }
    private void updateAddressbook(int contactId, String addressbook){
        AddressBook toUpdate = addressbookRepository.findByAddressBookId(addressbook);
        String contactList = toUpdate.getContactlist() +','+contactId;
        toUpdate.setContactlist(contactList);
        addressbookRepository.save(toUpdate);
    }



}