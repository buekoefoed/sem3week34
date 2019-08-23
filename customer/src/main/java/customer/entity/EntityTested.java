package customer.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTested {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Customer cust0 = new Customer("Donald","Trump");
        Customer cust1 = new Customer("Vladimir","Putin");
        Customer cust2 = new Customer("Xi","Jinping");
        Customer cust3 = new Customer("Boris","Johnson");
        Customer cust4 = new Customer("Recep","Erdogan");
        Customer cust5 = new Customer("Ivanka", "Trump");

        try {
            em.getTransaction().begin();
            em.persist(cust0);
            em.persist(cust1);
            em.persist(cust2);
            em.persist(cust3);
            em.persist(cust4);
            em.persist(cust5);
            em.getTransaction().commit();

            System.out.println(cust0.getCreated());
            System.out.println(cust1.getCreated());
            System.out.println(cust2.getCreated());
            System.out.println(cust3.getCreated());
            System.out.println(cust4.getCreated());

        } finally {
            em.close();
        }

    }
}
