package com.github.kotvertolet.fridge.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.github.kotvertolet.fridge.model.Contact;

import java.util.List;

@Repository
public class ContactRepository {

    private final MongoOperations mongoOperations;

    public ContactRepository(@Autowired MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public void save(Contact contact) {
        mongoOperations.save(contact);
    }

    public Contact update(Contact contact) {
        Query query = new Query(Criteria.where("_id").is(contact.getId()));
        Update update = new Update();
        if (contact.getName() != null) {
            update.set("name", contact.getName());
        }
        if (contact.getNumber() != null) {
            update.set("number", contact.getNumber());
        }
        if (contact.getEmail() != null) {
            update.set("email", contact.getEmail());
        }
        return mongoOperations.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), Contact.class);
    }

    public Contact findOne(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Contact.class);
    }

    public List<Contact> findAll() {
        return mongoOperations.findAll(Contact.class);
    }

    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Contact.class);
    }
}
