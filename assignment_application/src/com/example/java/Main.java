package com.example.java;
import User.Account;
import User.User;
import User.UserEnums.Gender;
import User.UserEnums.Status;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        User myUser = new User();

        myUser.setNameAndSurName("Pero");
        myUser.setGender(Gender.MALE);

        myUser.setFinancialStatus(new Account(Locale.UK, 2103.45));
        myUser.setStatus(Status.ACTIVE);

        System.out.println("OK Lets GO! " + myUser.getNameAndSurName() + "  " + myUser.getGender().getValue() + "  " + myUser.getFinancialStatus().status());
    }
}
