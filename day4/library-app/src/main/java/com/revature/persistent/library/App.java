package com.revature.persistent.library;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Ride myRide;

        System.out.println("Do you want Premium ride? (true/false): ");
        boolean isPremium = sc.nextBoolean();

        if (isPremium) {
            myRide = new UberBlack();
        } else {
            myRide = new UberX();
        }

        System.out.println("Enter distance: ");
        double distance = sc.nextDouble();
        myRide.setDistance(distance);

        sc.nextLine(); // clear buffer
        System.out.println("Enter destination: ");
        String destination = sc.nextLine();

        System.out.println("Enter number of passengers: ");
        int passengers = sc.nextInt();



        myRide.requestRide(destination);
        myRide.requestride(destination, passengers);

        System.out.println("Your total is $ " + myRide.calculatefare());

    }
}
