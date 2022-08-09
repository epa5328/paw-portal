package edu.psu.sweng.pawportal.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Note by Kevin
 * We may want to delete Person class and move all info into both Customer and Employee class.
 * That way we can set input info to required with the following notation:
 * The unique param is to ensure there are no duplicate accounts with the same email
 */


@Entity
@Table(name = "customers")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 64)
    private String firstName;
    @Column(nullable = false, length = 64)
    private String lastName;
    @Column(nullable = false, length = 64)
    private String phoneNum;
    @Column(nullable = false, unique = true, length = 64)
    private String email;
    @Column(nullable = false, length = 64)
    private String address;

    @Column(nullable = false, length = 64)
    private String password;

    private String roles;


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @OneToMany
    private Set<Dog> dogs;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNum, String email, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    /*
    public static Customer getCustomer(Long id) {
        return customers.stream().filter(c -> id == c.getId()).findFirst().orElse(null);
    }
    */

    public void propagateChanges(Customer c) {
        this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.phoneNum = c.phoneNum;
        this.email = c.email;
        this.address = c.address;
    }
}
