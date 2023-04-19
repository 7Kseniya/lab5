package ru.se.ifmo.lab5.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executor {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(reader);
    public void run(){
        String[] userCommand;

        try {
            userCommand = new String[]{bufferedReader.readLine().trim().toLowerCase()};
            //userCommand[1] = ;
        } catch (IOException e) {
            IOHandler.println("");
        }
    }



}
