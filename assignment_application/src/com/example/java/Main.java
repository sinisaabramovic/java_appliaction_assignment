package com.example.java;

import User.UsersController;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	// write your code here
        System.out.println("Program begin \n");
        UsersController usersController = UsersController.getInstance();

        String dataFilePath = "/Users/sinisaabramovic/Java/Java/assignment_application/data/podaci.txt";

        usersController.importUsers(dataFilePath);
        usersController.printUsers();

        System.out.println("Program ended \n");

    }

}
