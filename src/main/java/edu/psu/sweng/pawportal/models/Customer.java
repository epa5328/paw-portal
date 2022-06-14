package edu.psu.sweng.pawportal.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Set<Dog> dogs;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNum, String email, String address, Long id, Set<Dog> dogs) {
        super(firstName, lastName, phoneNum, email, address);
        this.id = id;
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
