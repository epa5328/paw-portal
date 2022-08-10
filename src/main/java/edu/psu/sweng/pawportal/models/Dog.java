package edu.psu.sweng.pawportal.models;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 64)
    private String name;
    @Column(nullable = false)
    private long ownerId;
    @Column(nullable = false, length = 64)
    private String breed;
    @Column(nullable = false)
    private int size; //in inches
    @Column(nullable = false)
    private double weight; //in pounds
    @Column(nullable = false, length = 64)
    private String color;
    @Column(nullable = false, length = 64)
    private String temperament;
    @Column(nullable = true, length = 256)
    private String notes;

    public Dog() {
    }

    public Dog(String name, long ownerId, String breed, int size, double weight, String color, String temperament, String notes) {
        this.name = name;
        this.ownerId = ownerId;
        this.breed = breed;
        this.size = size;
        this.weight = weight;
        this.color = color;
        this.temperament = temperament;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
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

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public void propagateChanges(Dog d) {
        this.name = d.name;
        this.breed = d.breed;
        this.size = d.size;
        this.weight = d.weight;
        this.color = d.color;
        this.temperament = d.temperament;
        this.notes = d.notes;
    }
}
