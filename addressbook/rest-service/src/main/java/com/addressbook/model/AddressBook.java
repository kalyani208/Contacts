package com.addressbook.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class AddressBook
{
    @Id
    @Column
    private String addressBookId;

    @Column
    private String Contactlist;

    public AddressBook(String addressBookId, String contactlist) {
        this.addressBookId = addressBookId;
        Contactlist = contactlist;
    }

    public String getAddressBookId()
    {
        return addressBookId;
    }
    public void setAddressBookId(String addressBookId)
    {
        this.addressBookId = addressBookId;
    }
    public String getContactlist() {
        return Contactlist;
    }

    public void setContactlist(String contactlist) {
        Contactlist = contactlist;
    }


}