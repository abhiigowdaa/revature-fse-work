package com.revature.persistent.library;

public class UberX extends Ride{
    @Override
    public double calculatefare() {
        return getDistance()*1.5;
    }
}
