package com.github.kotvertolet.fridge.services;

import com.github.kotvertolet.fridge.model.Contact;
import com.github.kotvertolet.fridge.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(@Autowired ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void add(Contact contact) {
        contact.setId(UUID.randomUUID().toString());
        contactRepository.save(contact);
    }

    public Contact update(Contact contact) {
        return contactRepository.update(contact);
    }

    public Contact findOne(String id) {
        return contactRepository.findOne(id);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public void remove(String id) {
        contactRepository.remove(id);
    }
}
