package com.hotelservice.utils;

public class UserServiceNotLoaded extends RuntimeException{
    public UserServiceNotLoaded() {
        super("User Service Not Loaded");
    }
}
