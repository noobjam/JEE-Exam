package DAO;

import jakarta.persistence.*;
import Model.Project;

import java.util.List;

public class ProjectDao {
    private static EntityManager em;

    public ProjectDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
        em = entityManagerFactory.createEntityManager();
    }

    public void save(Project project) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(project);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public static List<Project> getAllProjects() {
        Query query = em.createQuery("SELECT p FROM Project p");
        return query.getResultList();
    }

    public static Project findById(long id) {
        return em.find(Project.class, id);
    }


}
