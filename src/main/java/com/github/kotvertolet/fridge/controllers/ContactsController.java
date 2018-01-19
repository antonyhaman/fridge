package com.github.kotvertolet.fridge.controllers;

import com.github.kotvertolet.fridge.model.Contact;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.github.kotvertolet.fridge.services.ContactService;

import java.util.List;

@RestController
@RequestMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "/contacts", description = "Controller for contacts")
public class ContactsController {

    private final ContactService contactService;

    public ContactsController(@Autowired ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a contact", httpMethod = "POST")
    public Contact addContact(
            @ApiParam(value = "Contacts name")
            @RequestParam(name = "Name") String name,
            @ApiParam(value = "Contacts number")
            @RequestParam(name = "Number") String number,
            @ApiParam(value = "Contacts email")
            @RequestParam(name = "Email") String email) {
        Contact contact = new Contact(name, number, email);
        contactService.add(contact);
        return contactService.findOne(contact.getId());
    }

    @PostMapping("/update")
    @ApiOperation(value = "Updates the contact", httpMethod = "POST")
    public Contact updateContacts(
            @ApiParam(value = "ID", required = true)
            @RequestParam(name = "ID") String id,
            @ApiParam(value = "Contacts name")
            @RequestParam(name = "Name", required = false) String name,
            @ApiParam(value = "Contacts number")
            @RequestParam(name = "Number", required = false) String number,
            @ApiParam(value = "Contacts email")
            @RequestParam(name = "Email", required = false) String email) {
        Contact contact = new Contact(id, name, number, email);
        return contactService.update(contact);
    }

    @GetMapping
    @ApiOperation(value = "Returns all contacts", httpMethod = "GET")
    public List<Contact> showAll() {
        return contactService.findAll();
    }
}
