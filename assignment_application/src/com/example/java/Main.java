package com.example.java;

import User.Account;
import User.Name;
import User.User;
import User.UserEnums.Gender;
import User.UserEnums.Status;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Program begin \n");
        User myUser = new User();

        String dataFile = "/Users/sinisaabramovic/Java/Java/assignment_application/data/podaci.txt";

        try {
            InputStream input = new FileInputStream(dataFile);

            myUser.setNameAndSurName(new Name("Pero", "", "Kona"));
            myUser.setGender(Gender.MALE);
            myUser.setFinancialStatus(new Account(Locale.UK, 2103.45));
            myUser.setStatus(Status.ACTIVE);
            System.out.println("Debug user : \n" + myUser.toString());

        }catch(FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("Program ended \n");

    }
}
