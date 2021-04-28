package com.example.repository;

import com.example.entity.MovieEntity;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository extends AbstractRepository<MovieEntity> {
    private static EntityManagerFactory entFact;
    private static EntityManager entMng;

    public MovieRepository(EntityManagerFactory entFact, EntityManager entMng) {
        this.entFact = entFact;
        this.entMng = entMng;
    }

    public void create(Long id, String title, Time date, long duration, Long score) {
        entMng.getTransaction().begin();

        MovieEntity m = new MovieEntity();
        m.setId(id);
        m.setTitle(title);
        m.setDuration(duration);
        m.setReleaseDate(date);
        m.setScore(score);

        entMng.persist(m);
        entMng.getTransaction().commit();
    }

    public List<MovieEntity> findByName(String name) {
        List<MovieEntity> obj = new ArrayList<>();

        Query all = entMng.createNamedQuery("MovieEntity.findByName");
        all.setParameter("name", name);
        obj = all.getResultList();

        return obj;
    }
}
