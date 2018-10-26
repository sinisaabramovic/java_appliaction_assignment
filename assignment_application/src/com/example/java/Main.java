package com.example.java;

import User.User;

public class Main {

    public static void main(String[] args) {
	// write your code here

        User myUser = new User();

        myUser.setNameAndSurName("Pero");

        System.out.println("OK Lets GO! " + myUser.getNameAndSurName());
    }
}
