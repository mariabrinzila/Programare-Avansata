package com.example.repository;

import com.example.entity.ChartEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Time;

public class ChartRepository extends AbstractRepository<ChartEntity> {
    private static EntityManagerFactory entFact;
    private static EntityManager entMng;

    public ChartRepository(EntityManager em, EntityManagerFactory emf) {
        this.entFact = emf;
        this.entMng = em;
    }

    public void create(Long id, String name, Time creation) {
        entMng.getTransaction().begin();

        ChartEntity c = new ChartEntity();
        c.setId(id);
        c.setName(name);
        c.setCreation(creation);

        entMng.persist(c);
        entMng.getTransaction().commit();
    }
}
