package com.programacion.distribuida.servicios;

import com.programacion.distribuida.db.Authors;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Authors> {
}
