package br.com.kelvinsantiago.resources;

import br.com.kelvinsantiago.domain.entities.Category;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/categories")
public class CategoryResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getString(@PathParam("id") long id) {
        return Category.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> findAll() {
        return Category.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(Category category) {
        PanacheEntityBase.persist(category);
        return Response.ok(category).status(201).build();
    }


}