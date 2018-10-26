package com.example.java;

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
import java.util.Locale;

public class Main {

    /*
    Blue print
    {"Broj tečajnice":"204","
    Datum primjene":"24.10.2018",
    "Država":"Australija",
    "Šifra valute":"036",
    "Valuta":"AUD",
    "Jedinica":1,
    "Kupovni za devize":"4,567061",
    "Srednji za devize":"4,580803",
    "Prodajni za devize":"4,594545"}
    */
    public static void main(String[] args) {
	// write your code here


        try{
            String sURL = "http://api.hnb.hr/tecajn/v1?datum=2018-10-24";
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));

            JSONParser parser;
            parser = new JSONParser();

            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                JSONArray a = (JSONArray) parser.parse(inputLine);

                for (Object o : a) {
                    JSONObject jsonObject = (JSONObject) o;

                    String id = (String) jsonObject.get("Broj tečajnice");
                    System.out.println("Broj tečajnice : " + id);

                    id = (String) jsonObject.get("Datum primjene");
                    System.out.println("Datum primjene : " + id);

                    id = (String) jsonObject.get("Država");
                    System.out.println("Država : " + id);

                    id = (String) jsonObject.get("Valuta");
                    System.out.println("Valuta : " + id);

                    Long idInt = (Long) jsonObject.get("Jedinica");
                    System.out.println("Jedinica : " + idInt);

                    id = (String) jsonObject.get("Kupovni za devize");
                    System.out.println("Kupovni za devize : " + id);

                    id = (String) jsonObject.get("Srednji za devize");
                    System.out.println("Srednji za devize : " + id);

                    id = (String) jsonObject.get("Prodajni za devize");
                    System.out.println("Prodajni za devize : " + id);

                    System.out.println("\n");
                }
            }

            in.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
