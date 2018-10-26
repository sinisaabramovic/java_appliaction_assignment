package com.example.java;
import User.User;
import User.UserEnums.Gender;
import User.UserEnums.Status;

public class Main {

    public static void main(String[] args) {
	// write your code here
        User myUser = new User();


        myUser.setNameAndSurName("Pero");
        myUser.setGender(Gender.MALE);

        System.out.println("OK Lets GO! " + myUser.getNameAndSurName() + "  " + myUser.getGender().getValue());
    }
}
