package com.hotelservice;

import com.hotelservice.bin.UserServiceSerialization;
import com.hotelservice.data.Guest;
import com.hotelservice.data.Room;
import com.hotelservice.data.UserService;
import com.hotelservice.utils.Parser;

import java.time.LocalDate;
import java.util.*;

public class MenuConsoleProgramme {
    static Scanner scanner = new Scanner(System.in);

    public static void menu1(UserService userService) {
        System.out.println(
                "1.Wyświetl liste pokoi wraz ze statusem\n" +
                        "2.Wyświetl listę wszystkich dostępnych pokoi\n" +
                        "3.Pokaż listę pokoi zajętych\n" +
                        "4.Zrezerwuj pokój\n" +
                        "5.Zwolnij pokój\n" +
                        "6.Pokoje do posprzątania\n" +
                        "7.Posprzątaj pokój\n" +

                        "0.Wyjdź"
        );
        int choice = Parser.scannerParserStringToInt();

        switch (choice) {
            case 1:
                getAllRooms(userService);
                break;
            case 2:
                printAvailableRooms(userService);
                break;
            case 3:
                printOccupiedRooms(userService);
                break;
            case 4:
                consoleRegisterNewRoom(userService);
                break;
            case 5:
                System.out.println("Podaj nr pokoju");
                printOccupiedRooms(userService);
                userService.UnregisterRoom(Parser.scannerParserStringToInt());
                break;
            case 6:
                System.out.println("Pokoje do posprzątanie:");
                for (Room room : userService.getAllRooms()) {
                    if (!room.isClean()) {
                        System.out.println(room);
                    }
                }
                break;
            case 7:
                for (Room room : userService.getAllRooms()) {
                    if (!room.isClean()) {
                        System.out.println(room);
                    }
                }
                System.out.println("Podaj nr pokoju który ma być posprzątany");
                userService.cleanRoom(Parser.scannerParserStringToInt());
                break;

            case 0:
                UserServiceSerialization.saveUserService(userService);
                System.exit(1);
        }
    }

    private static void getAllRooms(UserService userService) {
        for (Room room :
                userService.getAllRooms()) {
            System.out.println(room);
        }
    }

    private static void printAvailableRooms(UserService userService) {
        userService.getAvailableRooms().forEach(room -> {
            System.out.println("Rooms available: " + room.toString());
        });
    }

    private static void printOccupiedRooms(UserService userService) {
        for (Room room : userService.getAllRooms()) {
            if (!room.isAvailable()) {
                System.out.println(room + "Date of Unregister: " + room.getDateOfUnregister());
            }
        }
    }

    private static void consoleRegisterNewRoom(UserService userService) {
        Deque<Guest> adder = new LinkedList<>();
        System.out.println("Wprowadź listę lokatorów");

        function:
        while (true) {
            System.out.println("Obecni lokatorzy:" + adder.toString());
            System.out.println("1:Dodaj\n2.Usuń ostatni\n3.Gotowe\n4.Anuluj ");

            int choice = Parser.scannerParserStringToInt();
            switch (choice) {
                case 1:
                    System.out.println("Imie");
                    String firstname = scanner.nextLine();
                    System.out.println("Nazwisko");
                    String lastname = scanner.nextLine();
                    System.out.println("Data urodzenia w fromacie dd-mm-yyyy");

                    adder.addFirst(new Guest(firstname, lastname, Parser.scannerParserStringToDate()));
                    break;
                case 2:
                    if (!adder.isEmpty()) {
                        adder.removeFirst();
                    }
                    break;
                case 3:
                    if (adder.isEmpty()) {
                        System.out.println("Lista pusta");
                        break;
                    }
                    break function;
                case 4:
                    break function;
            }
        }
        if (adder.isEmpty()) {
            return;
        }
        System.out.println("Podaj date zameldowania dd-mm-yyyy");
        LocalDate dateofregister = Parser.scannerParserStringToDate();
        System.out.println("Podaj date wymeldowania");
        LocalDate dateofunregister = Parser.scannerParserStringToDate();
        getAllRooms(userService);
        System.out.println("Podaj nr pokoju");
        int nr = Parser.scannerParserStringToInt();
        List<Guest> guests = new ArrayList<>(adder);
        if (adder.size() > userService.getRoomById(nr).getHowManyPersons()) {
            System.err.println("Nieprawidłowy rozmiar pokoju");
            return;
        }

        userService.registerNewUserToRoom(nr, guests, dateofregister, dateofunregister);
    }
}
