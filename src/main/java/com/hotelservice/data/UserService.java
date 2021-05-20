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
        if (hotel.getRoomById(nrOfRoom).isAvailable()||hotel.getRoomById(nrOfRoom).isClean()) {
            hotel.setRoomUnavailAble(nrOfRoom);
            hotel.setGuests(nrOfRoom,guests);
        }
        if (!hotel.getRoomById(nrOfRoom).isClean()){
            System.out.println("Pokój nieposprzątany nie można zarezerwować");
        }
    }
    public void UnregisterRoom(int nrOfRoom){
        if (!hotel.getRoomById(nrOfRoom).isAvailable()){
            hotel.setRoomAvailAble(nrOfRoom);

            hotel.getRoomById(nrOfRoom).setClean(false);
            resetGuestsRoom(nrOfRoom);
        }
    }
    public void resetGuestsRoom(int nrOfRoom){
        hotel.unregisterRoom(nrOfRoom);
    }
    public void cleanRoom(int nrOfRoom){
        hotel.cleanRoom(nrOfRoom);
    }

}
