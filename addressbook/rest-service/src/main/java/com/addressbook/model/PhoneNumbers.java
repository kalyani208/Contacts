package com.addressbook.model;

import javax.persistence.*;

@Entity
@Table
public class PhoneNumbers
{
    @Id
    @Column
    private int id;

    @Column
    private String phoneType;
    @Column
    private String phoneNumber;

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    @Column
    private int contactid;
    @ManyToOne()
    private Contact contact;

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public PhoneNumbers(int id, String phoneType, String phoneNumber, int contactid) {
        this.id = id;
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
        this.contactid = contactid;
    }

    public PhoneNumbers(){
    }
    @Override
    public String toString() {
        return "PhoneNumbers [id=" + id + ", phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + "]";
    }
}