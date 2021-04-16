package com.addressbook.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Contact
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int contactid;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String company;
    @Column
    private String email;

    public int getContactid()
    {
        return contactid;
    }
    public void setContactid(int contactid)
    {
        this.contactid = contactid;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    @OneToMany(mappedBy = "contact")
    private List<PhoneNumbers> phoneNumbersList;

    public Contact(int contactid, String firstname, String lastname, String company, String email) {
        this.contactid = contactid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.email = email;
    }

    public Contact(){}
    @Override
    public String toString() {
        return "Contact [contactid=" + contactid + ", email=" + email + ", company=" + company + ", lastname=" + lastname + ",firstname=" + firstname + "]";
    }
}