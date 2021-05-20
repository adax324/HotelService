package com.hotelservice.data;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    private Hotel hotel=new Hotel();


    public List<Room> getAllRooms(){
        return hotel.getRooms();
    }
    public List<Room> getAvailableRooms(){
        return hotel.getRoomsAvailable();
    }
    public void registerNewUserToRoom(int nrOfRoom,List<Guest> guests,LocalDate dayOfRegister,LocalDate dayOfUnregister){
        if (hotel.getRoomById(nrOfRoom).isAvailable()||hotel.getRoomById(nrOfRoom).isClean()) {
            hotel.setRoomUnavailAble(nrOfRoom);
            hotel.setGuests(nrOfRoom,guests);
            hotel.setRegisterDay(nrOfRoom,dayOfRegister);
            hotel.setUnregisterDay(nrOfRoom,dayOfUnregister);
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
        hotel.unregisterUserFromRoom(nrOfRoom);
    }
    public void cleanRoom(int nrOfRoom){
        hotel.cleanRoom(nrOfRoom);
    }

}
