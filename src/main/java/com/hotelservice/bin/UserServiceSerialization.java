package com.hotelservice.bin;

import com.hotelservice.userservice.UserService;
import com.hotelservice.utils.UserServiceNotLoaded;

import java.io.*;

public class UserServiceSerialization {
    public static final String PATH_TO_USER_SERVICE_FILE = "src/main/java/com/hotelservice/bin/UserServiceSerialized.Bin";

    public static void saveUserService(UserService userService) {
        File file = new File(PATH_TO_USER_SERVICE_FILE);
        try {
            ObjectOutputStream outputStreamWriter = new ObjectOutputStream(new FileOutputStream(file));
            outputStreamWriter.writeObject(userService);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserService loadUserService() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH_TO_USER_SERVICE_FILE));
            UserService userService = (UserService) objectInputStream.readObject();
            objectInputStream.close();
            return userService;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new UserServiceNotLoaded();
    }
}
