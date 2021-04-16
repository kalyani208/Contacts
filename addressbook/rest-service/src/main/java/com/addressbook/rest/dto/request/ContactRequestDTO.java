package com.addressbook.rest.dto.request;

import java.util.ArrayList;
import java.util.List;

public class ContactRequestDTO {

    private String addressbook;
    private String firstname;
    private String lastname;
    private String email;
    private String company;
    private String phonenumber;
    private String phonetype;

    public ContactRequestDTO(String addressbook, String firstname, String lastname, String email, String company, String phonenumber, String phonetype) {
        this.addressbook = addressbook;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.company = company;
        this.phonenumber = phonenumber;
        this.phonetype = phonetype;
    }

    public String getAddressbook() {
        return addressbook;
    }

    public void setAddressbook(String addressbook) {
        this.addressbook = addressbook;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }





}
