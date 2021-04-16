package com.addressbook.rest.repository;

import com.addressbook.model.AddressBook;
import com.addressbook.model.PhoneNumbers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressbookRepository extends CrudRepository<AddressBook, Integer> {
    List<AddressBook> findAll();

    AddressBook findByAddressBookId(String Id);

}

