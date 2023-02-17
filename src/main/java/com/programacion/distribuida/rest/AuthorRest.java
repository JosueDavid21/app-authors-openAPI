package com.programacion.distribuida.rest;

import com.programacion.distribuida.db.Authors;
import com.programacion.distribuida.servicios.AuthorRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @GET
    @Path("/{id}")
    @Operation(summary = "Retorna un objetos",
            description = "Return Author")
    @APIResponse(responseCode = "404", description = "No hay Autores")
    public Authors findById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @Inject AuthorRepository repository;

    @GET
    @Operation(summary = "Retorna una lista de objetos",
            description = "Return List<Author>")
    @APIResponse(responseCode = "404", description = "No hay Autores")
    public List<Authors> findAll() {
        return repository
                .findAll()
                .list();
    }

    @POST
    @Operation(summary = "Recibe un objeto",
            description = "Param Author, el cual sera creado en la BDD")
    @APIResponse(responseCode = "404", description = "Author no ingresado")
    public void insert(Authors obj) {
        repository.persist(obj);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Recibe un objeto",
            description = "Param Author, el cual sera actualizado en la BDD")
    @APIResponse(responseCode = "404", description = "Author no actualizado")
    public void update(Authors obj, @PathParam("id") Long id) {

        var author = repository.findById(id);

        author.setFirtName(obj.getFirtName());
        author.setLastName(obj.getLastName());
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Recibe un objeto",
            description = "Param Author, el cual sera eliminado de la BDD")
    @APIResponse(responseCode = "404", description = "Author no eliminado")
    public void delete( @PathParam("id") Long id ) {
        repository.deleteById(id);
    }
}
