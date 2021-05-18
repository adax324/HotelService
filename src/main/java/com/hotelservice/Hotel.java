package com.hotelservice;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    List<Room> rooms;

    public Hotel() {
        generateRooms();
    }

    private void generateRooms() {
        rooms = new ArrayList<>();
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

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getRoomsAvailable() {
        return
                rooms.stream()
                        .filter(room -> room.isAvailable() == true)

                        .collect(Collectors.toList());
    }
    public Room getRoomById(int id){
//        Optional<Room> roomtemp=this.rooms.stream()
//                .filter(room -> room.getId()==id)
//                .findFirst();
//        return roomtemp.orElse(null);


        return this.rooms.get(id-1);

    }

    public void setRoomUnavailAble(int nrOfRoom) {
        this.rooms.get(nrOfRoom-1).setAvailable(false);
    }

    public void setRoomAvailAble(int nrOfRoom) {
        this.rooms.get(nrOfRoom-1).setAvailable(true);
    }
}
