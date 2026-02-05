package com.revature.persistent.library;

public class UberBlack extends Ride{
    @Override
    public double calculatefare() {
        return getDistance()*4.0;
    }
}
