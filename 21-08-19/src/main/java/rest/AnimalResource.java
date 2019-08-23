/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bueko
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    public Animal getAnimal() {
    Animal a0 = new Animal("Duck",2017,"Quack");
    Animal a1 = new Animal("Cow",2011,"Moo");
    Animal a2 = new Animal("Dog",2014,"Bark");
    Animal a3 = new Animal("Cat",2005,"Miaow");
            
    List<Animal> animals = new ArrayList<>();
    animals.add(a0);
    animals.add(a1);
    animals.add(a2);
    animals.add(a3);
    Random r = new Random();
    int i = r.nextInt(4);
    return animals.get(i);
    }
    
    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello world!";
    }
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String random(){
        return new Gson().toJson(getAnimal());
    }


    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
