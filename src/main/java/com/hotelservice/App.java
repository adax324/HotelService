package com.hotelservice;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{   private static Scanner scanner=new Scanner(System.in);
    private static UserService userService=new UserService();
    public static void main( String[] args )
    {
            while (true){
                menu1();
            }


     }
     public static void menu1(){
         System.out.println(
                 "1.Wyświetl liste pokoi wraz ze statusem\n" +
                         "2.Wyświetl listę wszystkich dostępnych pokoi\n" +
                         "3.Zrezerwuj pokój\n" +
                         "4.Zwolnij pokój\n"+

                         "0.Wyjdź"
         );
         int choice=scanner.nextInt();
         scanner.nextLine();

         switch (choice){
             case 1:
                 for (Room room :
                         userService.getAllRooms()) {
                     System.out.println("Id of room: "+room.getId()+" is available: "+(room.isAvailable()?"Tak":"Nie"));
                 }
                 break;
             case 2:
                 userService.getAvailableRooms().forEach(room -> {
                     System.out.println("Rooms available: "+room.toString());
                 });
                 break;
             case 3:
                 System.out.println("Podaj nr pokoju: ");
                 userService.registerNewUserToRoom(scanner.nextInt());
                 scanner.nextLine();
                 break;
             case 4:
                 System.out.println("Podaj nr pokoju");
                 userService.clearRoom(scanner.nextInt());
                 scanner.nextLine();
                 break;
             case 0:
                 System.exit(1);
         }
     }

}
