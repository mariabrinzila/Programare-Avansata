package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSONFORMOVIE", schema = "STUDENT")
@IdClass(PersonformovieEntityPK.class)
public class PersonformovieEntity {
    private Long id;
    private String job;
    private long movieid;
    private long personid;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "JOB", nullable = false, length = 20)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Id
    @Column(name = "MOVIEID", nullable = false, precision = 0)
    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    @Id
    @Column(name = "PERSONID", nullable = false, precision = 0)
    public long getPersonid() {
        return personid;
    }

    public void setPersonid(long personid) {
        this.personid = personid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonformovieEntity that = (PersonformovieEntity) o;
        return movieid == that.movieid && personid == that.personid && Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, movieid, personid);
    }
}
