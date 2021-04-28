package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GenreformovieEntityPK implements Serializable {
    private long movieid;
    private long genreid;

    @Column(name = "MOVIEID", nullable = false, precision = 0)
    @Id
    public long getMovieid() {
        return movieid;
    }

    public void setMovieid(long movieid) {
        this.movieid = movieid;
    }

    @Column(name = "GENREID", nullable = false, precision = 0)
    @Id
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
        GenreformovieEntityPK that = (GenreformovieEntityPK) o;
        return movieid == that.movieid && genreid == that.genreid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieid, genreid);
    }
}
