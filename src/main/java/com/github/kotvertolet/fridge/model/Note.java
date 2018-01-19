package com.github.kotvertolet.fridge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Note.COLLECTION_NAME)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    public static final String COLLECTION_NAME = "notes";

    @Id
    private String id;
    private String note;
    private String fridgeId;

}
