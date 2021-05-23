package com.hotelservice.userservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class UserService implements Serializable {
    private Hotel hotel = new Hotel();


    public List<Room> getAllRooms() {
        return hotel.getRooms();
    }

    public Room getRoomById(int id) {
        return hotel.getRoomById(id - 1);
    }

    public List<Room> getAvailableRooms() {
        return hotel.getRoomsAvailable();
    }

    private int nrOfRoomInList(int i) {
        return i - 1;
    }

    public void registerNewUserToRoom(int nrOfRoom, List<Guest> guests, LocalDate dayOfRegister, LocalDate dayOfUnregister) {
        if (nrOfRoom > hotel.getRooms().size()) {
            System.out.println("Nie ma takiego pokoju");
            return;
        }
        if (!hotel.getRoomById(nrOfRoomInList(nrOfRoom)).isAvailable()) {
            System.err.println("Pokój zajęty!!!");
        }
        if (!hotel.getRoomById(nrOfRoomInList(nrOfRoom)).isClean()) {
            System.err.println("Pokój nieposprzątany nie można zarezerwować");
        }


        if (hotel.getRoomById(nrOfRoomInList(nrOfRoom)).isAvailable() && hotel.getRoomById(nrOfRoomInList(nrOfRoom)).isClean()) {

            hotel.setGuests(nrOfRoomInList(nrOfRoom), guests);
            if (hotel.isRoomEmpty(nrOfRoomInList(nrOfRoom))) {
                return;
            }
            if (dayOfRegister.isAfter(dayOfUnregister)) {
                System.out.println("Data rejestracji nie może być większa niż data wyrejestrowania");
                return;
            }
            hotel.setRoomUnavailAble(nrOfRoomInList(nrOfRoom));
            hotel.setRegisterDay(nrOfRoomInList(nrOfRoom), dayOfRegister);
            hotel.setUnregisterDay(nrOfRoomInList(nrOfRoom), dayOfUnregister);
            System.out.println("Dodano gości do pokoju pomyślnie");
        }

    }

    public void UnregisterRoom(int nrOfRoom) {

        if (nrOfRoom <= hotel.getRooms().size() &&
                !hotel.getRoomById(nrOfRoomInList(nrOfRoom)).isAvailable()) {
            hotel.setRoomAvailAble(nrOfRoomInList(nrOfRoom));

            hotel.getRoomById(nrOfRoomInList(nrOfRoom)).setClean(false);
            resetGuestsRoom(nrOfRoomInList(nrOfRoom));
            System.out.println("Goście wymeldowani");
        } else {
            System.err.println("Nie ma takiego pokoju");
        }

    }

    public void resetGuestsRoom(int nrOfRoom) {
        hotel.unregisterUserFromRoom(nrOfRoom);
    }

    public void cleanRoom(int nrOfRoom) {
        if (nrOfRoomInList(nrOfRoom) <= hotel.getRooms().size()) {
            hotel.cleanRoom(nrOfRoom);
            System.out.println("Pokój posprzątany");
        } else {
            System.err.println("Nie ma takiego pokoju");
        }
    }

}
