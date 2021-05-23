package com.hotelservice;

import com.hotelservice.bin.UserServiceSerialization;
import com.hotelservice.userservice.UserService;

import static com.hotelservice.MenuConsoleProgramme.menu1;


public class Main {
    private static UserService userService = UserServiceSerialization.loadUserService();

    public static void main(String[] args) {
        ConsoleProgramStart();
    }

    private static void ConsoleProgramStart() {
        while (true) {
            menu1(userService);
        }
    }


}
