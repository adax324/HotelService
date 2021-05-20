package com.hotelservice;

import com.hotelservice.data.Guest;
import com.hotelservice.data.Room;
import com.hotelservice.data.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
                        "7.Pokaż listę pokoi zajętych\n"+

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
                consoleRegisterNewRoom(userService);
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
            case 7:
                for (Room room:userService.getAllRooms()){
                    if(!room.isAvailable()){
                        System.out.println(room+" "+room.getDateOfUnregister());
                    }
                }
                break;
            case 0:
                System.exit(1);
        }
    }
    private static void consoleRegisterNewRoom(UserService userService){
        Deque<Guest> adder=new LinkedList<>();
        System.out.println("Wprowadź listę lokatorów");
        function:while (true){
            System.out.println("Obecni lokatorzy:"+adder.toString());
            System.out.println("1:Dodaj\n2.usun ostatni\n3.gotowe");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Imie");
                    String firstname=scanner.nextLine();
                    System.out.println("Nazwisko");
                    String lastname=scanner.nextLine();
                    System.out.println("Data urodzenia w fromacie dd-mm-yyyy");
                    String birthDay=scanner.nextLine();
                    adder.addFirst(new Guest(firstname,lastname,birthDay));
                    break;
                case 2:
                    adder.removeFirst();
                    break;
                case 3:
                    break function;
            }
        }
        System.out.println("Podaj date zameldowania dd-mm-yyyy");
        LocalDate dateofregister=LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Podaj date wymeldowania");
        LocalDate dateofunregister=LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Podaj nr pokoju");
        int nr=scanner.nextInt();
        scanner.nextLine();
        List<Guest> guests=new ArrayList<>(adder);
        userService.registerNewUserToRoom(nr,guests,dateofregister,dateofunregister);
    }
}
