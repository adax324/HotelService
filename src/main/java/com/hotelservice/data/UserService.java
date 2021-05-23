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
            if(nrOfRoom>20){
                System.out.println("Nie ma takiego pokoju");
                return;
            }
            hotel.setGuests(nrOfRoom,guests);
            if (hotel.isRoomEmpty(nrOfRoom)){
                return;
            }
            if (dayOfRegister.isAfter(dayOfUnregister)){
                System.out.println("Data rejestracji nie może być większa niż data wyrejestrowania");
                return;
            }
            hotel.setRoomUnavailAble(nrOfRoom);
            hotel.setRegisterDay(nrOfRoom,dayOfRegister);
            hotel.setUnregisterDay(nrOfRoom,dayOfUnregister);
        }
        if (!hotel.getRoomById(nrOfRoom).isClean()){
            System.out.println("Pokój nieposprzątany nie można zarezerwować");
        }
    }
    public void UnregisterRoom(int nrOfRoom){
        if (nrOfRoom<=hotel.getRooms().size()&&!hotel.getRoomById(nrOfRoom).isAvailable()){
            hotel.setRoomAvailAble(nrOfRoom);

            hotel.getRoomById(nrOfRoom).setClean(false);
            resetGuestsRoom(nrOfRoom);
        }else{
            System.err.println("Nie ma takiego pokoju");
        }

    }
    public void resetGuestsRoom(int nrOfRoom){
        hotel.unregisterUserFromRoom(nrOfRoom);
    }
    public void cleanRoom(int nrOfRoom){
        if (nrOfRoom<=hotel.getRooms().size()){
            hotel.cleanRoom(nrOfRoom);
        } else {
            System.err.println("Nie ma takiego pokoju");
        }
    }

}
