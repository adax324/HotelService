package com.hotelservice;

import com.hotelservice.data.Guest;
import com.hotelservice.data.Room;
import com.hotelservice.data.UserService;

import java.util.List;
import java.util.Scanner;

public class MenuConsoleProgramme {
    private static Scanner scanner=new Scanner(System.in);
    public static void menu1(UserService userService){
        System.out.println(
                "1.Wyświetl liste pokoi wraz ze statusem\n" +
                        "2.Wyświetl listę wszystkich dostępnych pokoi\n" +
                        "3.Zrezerwuj pokój\n" +
                        "4.Zwolnij pokój\n"+
                        "5.Pokoje do posprzątania\n"+
                        "6.Posprzątaj pokój\n"+

                        "0.Wyjdź"
        );
        int choice=scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                for (Room room :
                        userService.getAllRooms()) {
                    System.out.println("Id of room: "+room.getId()+"Guestes:"+room.getGuests()+" is available: "+(room.isAvailable()?"Tak":"Nie"));
                }
                break;
            case 2:
                userService.getAvailableRooms().forEach(room -> {
                    System.out.println("Rooms available: "+room.toString());
                });
                break;
            case 3:
                System.out.println("Podaj nr pokoju: ");
                userService.registerNewUserToRoom(scanner.nextInt(),
                        List.of(new Guest("Adam","Hrycek","06-11-1998")));//do usuniecia w przyszłośći
                scanner.nextLine();
                break;
            case 4:
                System.out.println("Podaj nr pokoju");
                userService.UnregisterRoom(scanner.nextInt());
                scanner.nextLine();
                break;
            case 5:
                System.out.println("Pokoje do posprzątanie:");
                for (Room room:userService.getAllRooms()){
                    if (!room.isClean()){
                        System.out.println(room);
                    }
                }
                break;
            case 6:
                for (Room room:userService.getAllRooms()){
                    if (!room.isClean()){
                        System.out.println(room);
                    }
                }
                System.out.println("Podaj nr pokoju który ma być posprzątany");
                userService.cleanRoom(scanner.nextInt());
                scanner.nextLine();
                break;
            case 0:
                System.exit(1);
        }
    }
}
