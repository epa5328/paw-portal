package edu.psu.sweng.pawportal.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Note by Kevin
 * We may want to delete Person class and move all info into both Customer and Employee class.
 * That way we can set input info to required with the following notation:
 * @Column(nullable = false, unique = true, length = (some number length))
 * The unique param is to ensure there are no duplicate accounts with the same email
 */


@Entity
@Table(name = "customers")
public class Customer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Set<Dog> dogs;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNum, String email, String address, Set<Dog> dogs) {
        super(firstName, lastName, phoneNum, email, address);
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
}
