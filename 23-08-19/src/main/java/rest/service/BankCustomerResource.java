package rest.service;

import com.google.gson.Gson;
import entities.BankCustomer;
import facades.BankFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bankcustomer")
public class BankCustomerResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    BankFacade facade =  BankFacade.getBankFacade(emf);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @GET
    @Path("id")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerByID() {
        return new Gson().toJson(facade.getCustomerByID(5));
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllBankCustomers() {
        return new Gson().toJson(facade.getAllBankCustomers());
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
