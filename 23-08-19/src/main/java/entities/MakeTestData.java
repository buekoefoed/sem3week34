package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MakeTestData {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        BankCustomer bc0 = new BankCustomer("Hans","Hansen","a1234",5000.0,7,"info");
        BankCustomer bc1 = new BankCustomer("Jens","Jensen","b1234",2000.0,9,"info");
        BankCustomer bc2 = new BankCustomer("Rasmus","Rasmussen","c1234",9000.0,4,"info");
        BankCustomer bc3 = new BankCustomer("Kjeld","Kjeldsen","d1234",1000.0,1,"info");
        BankCustomer bc4 = new BankCustomer("Morten","Mortensen","e1234",4000.0,5,"info");
        BankCustomer bc5 = new BankCustomer("Anders","Andersen","f1234",6000.0,8,"info");

        try {
            em.getTransaction().begin();
            em.persist(bc0);
            em.persist(bc1);
            em.persist(bc2);
            em.persist(bc3);
            em.persist(bc4);
            em.persist(bc5);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }
}
