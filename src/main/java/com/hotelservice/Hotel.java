package com.hotelservice;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    Set<Room> rooms;

    public Hotel() {
        generateRooms();
    }

    private void generateRooms() {
        rooms = new HashSet<>();
        for (int i = 0, j = 1; i < 50; i++, j++) {
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

    public Set<Room> getRooms() {
        return rooms;
    }
}
