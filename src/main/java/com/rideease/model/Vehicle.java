package com.rideease.model;

public class Vehicle {
    private int id;
    private String brand;
    private String color;
    private String type;
    private String name;
    private int capacity;
    private double pricePerHour;
    
    public Vehicle() {
    }

    // Constructor
    public Vehicle(String brand, String color, String type, String name, int capacity, double pricePerHour) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.name = name;
        this.capacity = capacity;
        this.pricePerHour = pricePerHour;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}