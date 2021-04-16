package com.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class ContactInfo {
    private Contact contact = new Contact();
    private List<PhoneNumbers> phoneNumbers= new ArrayList<>();

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
