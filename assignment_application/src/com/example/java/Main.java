package com.example.java;

import User.UsersController;
import java.io.IOException;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        System.out.println("Program begin \n");

        // Base user controller
        UsersController usersController = UsersController.getInstance();

        String dataFilePath;
        dataFilePath = "data/podaci.txt";

        usersController.importUsers(dataFilePath);
        usersController.printUsers();

        System.out.println("Program ended \n");

    }

}
