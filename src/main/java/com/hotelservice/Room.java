package com.hotelservice;

public class Room {
    private int numberOfRoom;
    private int howManyPersons;
    private boolean toiletIncluded;
    private boolean isAvailable;

    public Room(int numberOfRoom, int howManyPersons, boolean toiletIncluded, boolean isAvailable) {
        this.numberOfRoom = numberOfRoom;
        this.howManyPersons = howManyPersons;
        this.toiletIncluded = toiletIncluded;
        this.isAvailable = isAvailable;
    }
}
