package edu.psu.sweng.pawportal.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String name;
    @ManyToOne
    private Customer owner;
    private String breed;
    private int size; //in inches
    private double weight; //in pounds
    private String color;
    private int temperament; //from 1 to 10
    private String notes;

    public Dog() {
    }

    public Dog(String name, Customer owner, String breed, int size, double weight, String color, int temperament, String notes) {
        this.name = name;
        this.owner = owner;
        this.breed = breed;
        this.size = size;
        this.weight = weight;
        this.color = color;
        this.temperament = temperament;
        this.notes = notes;
    }

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTemperament() {
        return temperament;
    }

    public void setTemperament(int temperament) {
        this.temperament = temperament;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
