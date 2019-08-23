package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankFacadeTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static BankFacade instance = BankFacade.getBankFacade(emf);

    @Test
    void getCustomerByID() {
        CustomerDTO bc = instance.getCustomerByID(3);
        assertEquals("Rasmus Rasmussen",bc.getFullName());
    }

    @Test
    void getCustomerByName() {
        List<CustomerDTO> bcs = instance.getCustomerByName("Rasmus");
        assertEquals(1,bcs.size());
    }

    @Test
    void addBankCustomer() {
        BankCustomer bc = instance.addBankCustomer(new BankCustomer("Søren","Sørensen","g1234",11000,10,"info"));
        assertEquals(7,instance.getAllBankCustomers().size());

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from BankCustomer bc where bc.firstName = 'Søren'").executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    void getAllBankCustomers() {
        List<BankCustomer> bcs = instance.getAllBankCustomers();
        assertEquals(6,bcs.size());
    }
}