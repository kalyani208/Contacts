package com.addressbook.rest.resources;


import com.addressbook.model.Contact;
import com.addressbook.model.ContactInfo;
import com.addressbook.rest.dto.request.ContactRequestDTO;
import com.addressbook.rest.dto.request.DeleteRequestDTO;
import com.addressbook.service.ContactsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;

import java.util.List;

@RestController
public class AddressBookResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ContactsInfoService contactsInfoService;

    @ApiOperation(value = "Get Contacts", notes = "Get all contacts of the addressBook passed")
    @ApiImplicitParam(value = "JSON API format", name="Accept", allowableValues="application/vnd.api+json" )
    @GetMapping(value= "/addressbook/contacts", produces= "application/vnd.api+json")
    public ResponseEntity<List<ContactInfo>> Contacts(@RequestParam String addressbookId) {
        ResponseEntity<List<ContactInfo>> responseEntity = new ResponseEntity<List<ContactInfo>>(contactsInfoService.getContacts(addressbookId), HttpStatus.OK);
        logger.info("Response:" + responseEntity);
        return responseEntity;
    }
    @ApiOperation(value = "Add Contacts", notes = "Add a new contact")
    @ApiImplicitParam(value = "JSON API format", name="Accept", allowableValues="application/vnd.api+json" )
    @PostMapping(value= "/addressbook/contacts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> Contacts(@RequestBody ContactRequestDTO contact ) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<Integer>(contactsInfoService.addContact(contact), HttpStatus.OK);
        logger.info("Response:" + responseEntity);
        return responseEntity;
    }

    @ApiOperation(value = "Delete Contacts", notes = "delete a contact")
    @ApiImplicitParam(value = "JSON API format", name="Accept", allowableValues="application/vnd.api+json" )
    @DeleteMapping(value= "/addressbook/contacts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Contact>> Contacts(@RequestBody DeleteRequestDTO contactName ) {
        ResponseEntity<List<Contact>> responseEntity = new ResponseEntity<List<Contact>>(contactsInfoService.deleteContact(contactName), HttpStatus.OK);
        logger.info("Response:" + responseEntity);
        return responseEntity;
    }


}
