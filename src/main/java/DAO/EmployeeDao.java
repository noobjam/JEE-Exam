package DAO;

import jakarta.persistence.*;
import Model.Employe;

import java.util.List;

public class EmployeeDao {
    private static EntityManager em;

    public void StudentDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
        em = entityManagerFactory.createEntityManager();
    }

    public static void save(Employe s) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(s);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    public static List<Employe> findAll() {
        Query query = em.createQuery("select s from Employe s");
        return query.getResultList();
    }

    public  Employe findById(long id) {
        return em.find(Employe.class, id);
    }

    public static void delete(long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Employe s = em.find(Employe.class, id);
            em.remove(s);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }



}
