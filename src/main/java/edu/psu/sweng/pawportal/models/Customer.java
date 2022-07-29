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
    private Long id;



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

    public Customer(String firstName, String lastName, String phoneNum, String email, String address, String password, Set<Dog> dogs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.password = password;
        this.dogs = dogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
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
}
