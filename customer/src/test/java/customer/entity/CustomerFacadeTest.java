package customer.entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFacadeTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static CustomerFacade instance = CustomerFacade.getCustomerFacade(emf);

    @Test
    void testFindByID() {
        Customer c = instance.findByID(3);
        assertEquals("Erdogan", c.getLastName());
    }

    @Test
    void testFindByLastName() {
        List<Customer> customers = instance.findByLastName("Trump");
        assertEquals(2,customers.size());
    }

    @Test
    void testGetNumberOfCustomers() {
        Long i = instance.getNumberOfCustomers();
        assertEquals(6, i);
    }

    @Test
    void testAllCustomers() {
        List<Customer> customers = instance.allCustomers();
        assertEquals(6, customers.size());
    }


    @Test
    void testAddCustomer() {
        Customer c = instance.addCustomer("Viktor", "Orban");
        assertEquals("Orban",instance.findByID(7).getLastName());
    }

}