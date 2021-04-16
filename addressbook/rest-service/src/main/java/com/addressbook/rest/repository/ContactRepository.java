package com.addressbook.rest.repository;

import com.addressbook.model.Contact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findAll();
    Contact findById(int Id);


    List<Contact> deleteById(int ContactId);

    @Query("select contactid from Contact u where u.firstname = ?1 AND u.lastname = ?2 ")
    int ContactByName(String firstname, String lastname);

}

