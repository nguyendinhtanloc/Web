package murach.data;

import murach.model.Account;
import javax.persistence.*;

public class AccountRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("loginPU");

    public Account findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.email = :email", Account.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
