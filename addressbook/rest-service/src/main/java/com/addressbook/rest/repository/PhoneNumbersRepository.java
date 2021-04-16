package com.addressbook.rest.repository;

import com.addressbook.model.Contact;
import com.addressbook.model.PhoneNumbers;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface PhoneNumbersRepository extends CrudRepository<PhoneNumbers, Integer> {

    List<PhoneNumbers> findAllByContactid(int id);
    PhoneNumbers findById(int Id);
    List<PhoneNumbers> deleteByContactid(int id);



}

