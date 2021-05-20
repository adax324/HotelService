package com.hotelservice.data;

import java.util.List;

public class UserService {
    private Hotel hotel=new Hotel();


    public List<Room> getAllRooms(){
        return hotel.getRooms();
    }
    public List<Room> getAvailableRooms(){
        return hotel.getRoomsAvailable();
    }
    public void registerNewUserToRoom(int nrOfRoom,List<Guest> guests){
        if (hotel.getRoomById(nrOfRoom).isAvailable()) {
            hotel.setRoomUnavailAble(nrOfRoom);
            hotel.setGuests(1,guests);
        }
    }
    public void clearRoom(int nrOfRoom){
        if (!hotel.getRoomById(nrOfRoom).isAvailable()){
            hotel.setRoomAvailAble(nrOfRoom);
        }
    }

}
