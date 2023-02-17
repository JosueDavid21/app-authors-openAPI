package com.programacion.distribuida.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authors {
    @Id
    @Getter @Setter private Long id;

    @Column(name = "first_name")
    @Getter @Setter private String firtName;

    @Column(name = "last_name")
    @Getter @Setter private String lastName;
}
