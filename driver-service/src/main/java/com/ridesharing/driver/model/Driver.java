package com.ridesharing.driver.model;

public class Driver {
    private String id;
    private String name;
    private String vehicleNumber;
    private String status;
    private double rating;

    public Driver() {
    }

    public Driver(String id, String name, String vehicleNumber, String status, double rating) {
        this.id = id;
        this.name = name;
        this.vehicleNumber = vehicleNumber;
        this.status = status;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
