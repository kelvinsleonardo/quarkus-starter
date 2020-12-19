package br.com.kelvinsantiago.resources;

import br.com.kelvinsantiago.domain.entities.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/products")
public class ProductResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Product getString(@PathParam("id") long id) {
        return entityManager.createQuery("select p from Product p where p.id = "+id, Product.class).getSingleResult();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }


}