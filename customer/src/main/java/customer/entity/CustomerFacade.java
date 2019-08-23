package customer.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);

            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query =
                    em.createQuery("Select c from Customer c where c.lastName like :lastname",Customer.class)
                            .setParameter("lastname",name).setMaxResults(10);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

    public Long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        Long i;
        try{
            TypedQuery<Long> query =
                    em.createQuery("select count(customer.id) from Customer customer",Long.class);
            i = query.getSingleResult();
        }finally {
            em.close();
        }
        return i;
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query =
                    em.createQuery("Select customer from Customer customer",Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }


    public Customer addCustomer(String fName, String lName) {
        Customer c = new Customer(fName,lName);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        }finally {
            em.close();
        }
    }

}
