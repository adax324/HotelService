package com.hotelservice.userservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private static int numbersOfRoom = 0;
    private final int id;
    private final int howManyPersons;
    private final boolean toiletIncluded;
    private boolean isAvailable;
    private List<Guest> guests;
    private boolean isClean;
    private LocalDate dateOfRegister;
    private LocalDate dateOfUnregister;


    public Room(int howManyPersons, boolean toiletIncluded, boolean isAvailable) {
        numbersOfRoom++;
        id = numbersOfRoom;
        this.howManyPersons = howManyPersons;
        this.toiletIncluded = toiletIncluded;
        this.isAvailable = isAvailable;
        this.guests = new ArrayList<>();
        this.isClean = true;
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

    public void resetGuests() {
        this.guests = new ArrayList<>();
    }

    @Override
    public String toString() {


        String toString = "Room{" + "nr of room: " + id +
                " howManyPersons=" + howManyPersons +
                ", toiletIncluded=" + toiletIncluded +
                ", isAvailable=" + isAvailable +
                ", is Cleaned= " + isClean +
                "}";
        if (!guests.isEmpty()) {
            toString += " " + guests;
        }
        return toString;

    }

    public int getHowManyPersons() {
        return howManyPersons;
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public LocalDate getDateOfUnregister() {
        return dateOfUnregister;
    }

    public void setDateOfUnregister(LocalDate dateOfUnregister) {
        this.dateOfUnregister = dateOfUnregister;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }


}
