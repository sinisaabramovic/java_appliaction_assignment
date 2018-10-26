package com.example.java;

import User.UsersController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
