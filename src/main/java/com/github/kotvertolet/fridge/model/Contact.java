package com.github.kotvertolet.fridge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = Contact.COLLECTION_NAME)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

    public static final String COLLECTION_NAME = "contacts";

    @Id
    private String id;
    private String name;
    private String number;
    private String email;

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }
}