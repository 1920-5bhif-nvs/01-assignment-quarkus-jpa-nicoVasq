package at.htl.quarkus;

import at.htl.entity.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    PersonService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Person> plist = service.findAll();
        if(plist.size() == 0)
            return Response.status(404).build();

        return Response.status(200).entity(service.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getByName(@PathParam("name") String name){
        Person p = service.findPersonByName(name);
        if(p == null)
            return Response.status(404).build();

        return Response.status(200).entity(p).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response postPerson(@PathParam("name") String name){
        return Response.status(200).entity(service.createPerson(name)).build();
    }

}
