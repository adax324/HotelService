package com.hotelservice;

import java.util.List;
import java.util.Set;

public class UserService {
    private Hotel hotel=new Hotel();


    public List<Room> getAllRooms(){
        return hotel.getRooms();
    }
    public List<Room> getAvailableRooms(){
        return hotel.getRoomsAvailable();
    }
    public void registerNewUserToRoom(int nrOfRoom){
        if (hotel.getRoomById(nrOfRoom).isAvailable()) {
            hotel.setRoomUnavailAble(nrOfRoom);
        }
    }
    public void clearRoom(int nrOfRoom){
        if (!hotel.getRoomById(nrOfRoom).isAvailable()){
            hotel.setRoomAvailAble(nrOfRoom);
        }
    }

}
