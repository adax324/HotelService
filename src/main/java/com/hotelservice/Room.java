package com.hotelservice;

import java.util.Objects;

public class Room {
    private static int numberOfRoom=0;
    private int howManyPersons;
    private boolean toiletIncluded;
    private boolean isAvailable;

    public Room(int howManyPersons, boolean toiletIncluded, boolean isAvailable) {
        numberOfRoom++;
        this.howManyPersons = howManyPersons;
        this.toiletIncluded = toiletIncluded;
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return numberOfRoom == room.numberOfRoom && howManyPersons == room.howManyPersons && toiletIncluded == room.toiletIncluded && isAvailable == room.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRoom, howManyPersons, toiletIncluded, isAvailable);
    }

    @Override
    public String toString() {
        return "Room{" +
                "howManyPersons=" + howManyPersons +
                ", toiletIncluded=" + toiletIncluded +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
