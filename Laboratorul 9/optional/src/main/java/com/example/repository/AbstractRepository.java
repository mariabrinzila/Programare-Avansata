package com.example.repository;

import com.example.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends AbstractEntity> implements Serializable {
    protected Class<T> entity;
    protected static EntityManager entMng;
    private static EntityManagerFactory entFact;
    protected List<T> allEntities = new ArrayList<>();

    public void persist(T that) {
        entMng.persist(that);
        allEntities.add(that);
    }

    public static void BeforeAll() {
        entFact = Persistence.createEntityManagerFactory("Test");
    }

    public static void BeforeEach() {
        entMng = entFact.createEntityManager();
    }

    public boolean exists(T that) {
        if (that == null)
            return false;
        return entMng.find(that.getClass(), that.getId()) != null;
    }

    public void update(T that) {
        entMng.merge(that);
        allEntities.add(that);
    }

    public void remove(T that) {
        if (that == null)
            return;
        if (!entMng.contains(that)) {
            allEntities.remove(that);
        }
        entMng.remove(that);
    }

    public T refresh(T that) {
        if (!entMng.contains(that))
            that = entMng.merge(that);
        entMng.refresh(that);
        allEntities.add(that);
        return that;
    }

    public List<T> findAll() {
        List<T> result;
        if (allEntities == null)
            return null;

        String query = "SELECT ent FROM " + entity.getSimpleName() + " ent";
        result = entMng.createQuery(query).getResultList();
        return result;
    }

    public T findById(Long id) {
        if (id == null)
            return null;

        String query = "SELECT ent FROM " + entity.getSimpleName() + " ent WHERE ent.id = :id";
        Query q = entMng.createQuery(query).setParameter("id", id);
        List<T> result = q.getResultList();
        if (result == null)
            return null;
        return result.get(0);
    }

    public List<T> findByName(String name) {
        if (name == null)
            return null;

        String query = "SELECT ent FROM " + entity.getSimpleName() + " ent WHERE ent.name = :name";
        Query q = entMng.createQuery(query).setParameter("name", name);
        List<T> result = q.getResultList();
        return result;
    }
}
