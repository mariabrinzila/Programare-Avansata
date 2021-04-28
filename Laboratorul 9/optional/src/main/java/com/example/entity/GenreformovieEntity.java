package com.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GENREFORMOVIE", schema = "STUDENT")
@IdClass(GenreformovieEntityPK.class)
public class GenreformovieEntity {
    private Long id;
    private long movieid;
    private long genreid;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "GENREID", nullable = false, precision = 0)
    public long getGenreid() {
        return genreid;
    }

    public void setGenreid(long genreid) {
        this.genreid = genreid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreformovieEntity that = (GenreformovieEntity) o;
        return movieid == that.movieid && genreid == that.genreid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, genreid);
    }
}
