package edu.psu.sweng.pawportal.models;

import javax.persistence.*;

/**
 * Note by Kevin
 * We may want to delete Person class and move all info into both Customer and Employee class.
 * That way we can set input info to required with the following notation:
 * The unique param is to ensure there are no duplicate accounts with the same email
 * 
 * Emily -- DONE!
 */


@Entity
@Table(name = "customers")
public class Customer extends Person {

    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Customer() {}

    /*
    public static Customer getCustomer(Long id) {
        return customers.stream().filter(c -> id == c.getId()).findFirst().orElse(null);
    }
    */
}
