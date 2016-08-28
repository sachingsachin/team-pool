package com.prismoskills.persistence;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
    private String id;

    // Constructors
    public BaseEntity() {
    }
    public BaseEntity(String id) {
        this.id = id;
    }

    // Getter Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
