package com.hotelservice.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Guest implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private transient DateTimeFormatter dateTimeFormatter;
    private Period age;

    public Guest(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.birthDay = birthDay;
        this.age=Period.between(this.birthDay,LocalDate.now());
    }

    public int getAge() {
        return age.getYears();
    }

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age.getYears() +
                '}';
    }
}
