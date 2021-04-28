package com.example.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "PERSON", schema = "STUDENT")
public class PersonEntity extends AbstractEntity {
    private Long id;
    private String fullname;
    private Time birthdate;
    private Time deathdate;
    private long age;
    private String nationality;
    private Long rank;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FULLNAME", nullable = false, length = 50)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "BIRTHDATE", nullable = false)
    public Time getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Time birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "DEATHDATE", nullable = true)
    public Time getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Time deathdate) {
        this.deathdate = deathdate;
    }

    @Basic
    @Column(name = "AGE", nullable = false, precision = 0)
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "NATIONALITY", nullable = false, length = 20)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "RANK", nullable = true, precision = 0)
    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return age == that.age && Objects.equals(id, that.id) && Objects.equals(fullname, that.fullname) && Objects.equals(birthdate, that.birthdate) && Objects.equals(deathdate, that.deathdate) && Objects.equals(nationality, that.nationality) && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, birthdate, deathdate, age, nationality, rank);
    }
}
