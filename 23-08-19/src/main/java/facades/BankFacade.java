package facades;

import dto.CustomerDTO;
import entities.BankCustomer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankFacade {

    private static BankFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankFacade getBankFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getCustomerByID(int id){
        EntityManager em = getEntityManager();

        try {
            BankCustomer bc = em.find(BankCustomer.class, id);
            return new CustomerDTO(bc);
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name){
        EntityManager em = getEntityManager();

        try {
            TypedQuery<BankCustomer> bcs =
                    em.createQuery("select b from BankCustomer b where b.firstName like :name",BankCustomer.class)
                    .setParameter("name",name).setMaxResults(10);

            List<CustomerDTO> customerDTOS = new ArrayList<>();

            for (int i = 0; i < bcs.getResultList().size(); i++) {
                customerDTOS.add(new CustomerDTO(bcs.getResultList().get(i)));
            }
            return customerDTOS;
        } finally {
            em.close();
        }
    }

    public BankCustomer addBankCustomer(BankCustomer bc){
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(bc);
            em.getTransaction().commit();

            return bc;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers(){
        EntityManager em = getEntityManager();

        try {
            TypedQuery<BankCustomer> query =
                    em.createQuery("select bc from BankCustomer bc",BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
