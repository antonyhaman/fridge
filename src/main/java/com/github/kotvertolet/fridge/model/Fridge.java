package com.github.kotvertolet.fridge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Fridge.COLLECTION_NAME)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fridge {

    public static final String COLLECTION_NAME = "fridge";

    @Id
    private String id;
    private String name;

}
