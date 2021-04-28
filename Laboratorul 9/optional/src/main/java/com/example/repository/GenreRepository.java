package com.example.repository;

import com.example.entity.GenreEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GenreRepository extends AbstractRepository<GenreEntity> {
    private static EntityManagerFactory entFact;
    private static EntityManager entMng;

    public GenreRepository(EntityManager em, EntityManagerFactory emf) {
        this.entFact = emf;
        this.entMng = em;
    }

    public void create(Long id, String name) {
        entMng.getTransaction().begin();

        GenreEntity g = new GenreEntity();
        g.setId(id);
        g.setName(name);

        entMng.persist(g);
        entMng.getTransaction().commit();
    }
}
