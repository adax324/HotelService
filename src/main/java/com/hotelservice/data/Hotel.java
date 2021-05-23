package com.hotelservice.data;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        generateRooms();
    }

    public void cleanRoom(int nrOfRoom) {
        rooms.get(nrOfRoom).setClean(true);
    }

    public void unregisterUserFromRoom(int nrOfRoom) {
        rooms.get(nrOfRoom).resetGuests();
    }

    public void setRegisterDay(int nrOfRoom, LocalDate registerDay) {
        rooms.get(nrOfRoom).setDateOfRegister(registerDay);
    }

    public void setUnregisterDay(int nrOfRoom, LocalDate unregisterDay) {
        rooms.get(nrOfRoom).setDateOfUnregister(unregisterDay);
    }


    private void generateRooms() {
        rooms = new ArrayList<>();
        for (int i = 0, j = 1; i < 20; i++, j++) {
            if (j == 6) {
                j = 1;
            }
            boolean isThereToilet = true;
            if (j == 1) {
                isThereToilet = false;
            }
            rooms.add(new Room(j, isThereToilet, true));
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getRoomsAvailable() {
        return
                rooms.stream()
                        .filter(room -> room.isAvailable() == true)
                        .collect(Collectors.toList());
    }

    public Room getRoomById(int id) {
        return this.rooms.get(id);

    }

    public void setRoomUnavailAble(int nrOfRoom) {
        this.rooms.get(nrOfRoom).setAvailable(false);
    }

    public void setRoomAvailAble(int nrOfRoom) {
        this.rooms.get(nrOfRoom).setAvailable(true);
    }

    public void setGuests(int nrOfRoom, List<Guest> guests) {
        boolean thereIsAdult = false;
        for (Guest guest : guests) {
            if (guest.getAge() >= 18) {
                thereIsAdult = true;
            }
        }
        if (thereIsAdult) {
            this.rooms.get(nrOfRoom).addGuests(guests);
        } else {
            System.err.println("Nie ma osoby pełnoletniej błąd 666");
        }
    }

    public boolean isRoomEmpty(int nrOfRoom) {
        return rooms.get(nrOfRoom).getGuests().isEmpty();
    }
}
