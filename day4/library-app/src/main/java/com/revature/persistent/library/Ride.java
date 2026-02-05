package com.revature.persistent.library;

abstract class Ride {

    private double distance; // ENCAPSULATION: Hidden data

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance > 0) {
            this.distance = distance;
        }
    }

    public abstract double calculatefare();

    // Overloading: Same name, different inputs
    public void requestRide(String destination) {
        System.out.println("Finding ride to " + destination);
    }

    public void requestride(String destination, int passenger)
    {
        System.out.println("Finding ride for "+passenger+" people to "+destination);
    }
}

