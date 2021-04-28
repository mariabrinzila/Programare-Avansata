package com.example.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractEntity {
    protected Long id;
    protected String name;
    protected boolean jpa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJpa(File f) throws FileNotFoundException {
        Scanner in = new Scanner(f);
        String method = in.nextLine();

        if (method == "jpa")
            jpa = true;
        else
            jpa = false;
    }

    public boolean getJpa() {
        return jpa;
    }
}
