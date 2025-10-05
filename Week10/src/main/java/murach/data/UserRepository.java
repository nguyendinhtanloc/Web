package murach.data;

import murach.business.User;
import javax.persistence.*;
import java.util.List;

public class UserRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("murachPU");

    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public User findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }

    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }

    public void update(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(user);
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }

    public void delete(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.merge(user));
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }
}
