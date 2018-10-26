package com.example.java;

import User.Account;
import User.Name;
import User.User;
import User.UserView;
import User.UserEnums.Gender;
import User.UserEnums.Status;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	// write your code here
        System.out.println("Program begin \n");
        JSONParser jsonParser = new JSONParser();

        //User myUser = new User();
        UserView userView = new UserView();

        String dataFilePath = "/Users/sinisaabramovic/Java/Java/assignment_application/data/podaci.txt";

        try {
            FileReader reader = new FileReader(dataFilePath);
            Object object = jsonParser.parse(reader);

            JSONArray users = (JSONArray) object;
            int length = users.size();

            for(int i=0; i<length; i++){
                JSONObject jsonObject = (JSONObject) users.get(i);
                Set s = jsonObject.entrySet();
                Iterator iter = ((Set) s).iterator();

                System.out.println("+++++++ USER +++++++\n");
                while(iter.hasNext()){
                    Map.Entry me = (Map.Entry) iter.next();
                    System.out.println(me.getKey() + "  " + me.getValue());
                }
                System.out.println("+++++++ END OF USER +++++++\n");
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Program ended \n");

    }


    /*
        "id": "_5",
        "status": "aktivan",
        "stanje": "4.271,55 HRK",
        "dob": "33 god",
        "naziv": "Juliette Lancaster",
        "spol": "female",
        "tvrtka": "QUARMONY",
        "email": "juliettelancaster@quarmony.com",
        "telefon": "+385 (809) 531-2704",
        "adresa": "339 Coffey Street, Neahkahnie, Virginia, 8640"
     */

}
