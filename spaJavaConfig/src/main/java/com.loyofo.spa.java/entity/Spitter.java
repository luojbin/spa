package com.loyofo.spa.java.entity;

import java.util.Date;
import java.util.Objects;

public class Spitter {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public Spitter(){}

    public Spitter(Long id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this(null, firstName, lastName, username, password);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return Objects.equals(id, spitter.id) &&
                Objects.equals(firstName, spitter.firstName) &&
                Objects.equals(lastName, spitter.lastName) &&
                Objects.equals(username, spitter.username) &&
                Objects.equals(password, spitter.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password);
    }
}
