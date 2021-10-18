package com.legion.supportmybudget.test;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
@Component
public class Extractor implements StringCleaner {


    @Override
    public String extract(String s) {
        boolean matchFound = false;
        StringBuilder output = new StringBuilder();
        String string = "";
        BufferedReader reader = new BufferedReader(
                    new StringReader(s));

        try {
            while ((string = reader.readLine()) != null) {

                if ((string.length() > 0) && (string.contains("PARAGON"))) {
                    matchFound = true;
                }
                if(matchFound){
                    output.append(string).append("\n");
                }
                if (string.contains("SUMA")) {
                    matchFound = false;
                }
            }
        } catch (IOException e) { e.printStackTrace();}
        return output.toString().replaceAll("[_|]", "");
    }
}
