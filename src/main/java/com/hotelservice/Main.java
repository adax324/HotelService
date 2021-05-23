package com.hotelservice;

import com.hotelservice.data.UserService;

import static com.hotelservice.MenuConsoleProgramme.menu1;

/**
 * Hello world!
 *
 */
public class Main
{
    private static UserService userService=new UserService();
    public static void main( String[] args )
    {
        ConsoleProgramStart();


    }

    private static void ConsoleProgramStart() {
        while (true){
            menu1(userService);
        }
    }


}
