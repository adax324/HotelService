package com.hotelservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Comparable<Room> {
    private static int numbersOfRoom = 0;
    private int id;
    private int howManyPersons;
    private boolean toiletIncluded;
    private boolean isAvailable;
    private List<Guest> guests;


    public Room(int howManyPersons, boolean toiletIncluded, boolean isAvailable) {
        numbersOfRoom++;
        id = numbersOfRoom;
        this.howManyPersons = howManyPersons;
        this.toiletIncluded = toiletIncluded;
        this.isAvailable = isAvailable;
        this.guests = new ArrayList<>();
    }

    public void addGuests(List<Guest> guests) {
        boolean thereIsAdult = false;
        for (Guest guest : guests) {
            if (guest.getAge() >= 18) {
                thereIsAdult = true;
            }
        }
        if (thereIsAdult) {
            this.guests = guests;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && howManyPersons == room.howManyPersons && toiletIncluded == room.toiletIncluded && isAvailable == room.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, howManyPersons, toiletIncluded, isAvailable);
    }

    @Override
    public String toString() {
        return "Room{" + "nr of room:" + id +
                "howManyPersons=" + howManyPersons +
                ", toiletIncluded=" + toiletIncluded +
                ", isAvailable=" + isAvailable +
                "}\n+" +
                guests;

    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    @Override
    public int compareTo(Room room) {
        return Integer.compare(this.getId(), room.getId());
    }
}
