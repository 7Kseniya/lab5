package ru.se.ifmo.lab5;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.utils.Reader;

import java.io.IOException;
import java.util.LinkedHashMap;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) throws IOException {

        //check if the filename is passed as an argument
        if (args.length == 0 | args[0].trim().length() == 0) {
            System.out.println("Please provide the filename as an argument.");
            System.exit(1);
        }
        Reader reader = new Reader();
        LinkedHashMap<Integer, SpaceMarine> loadedCollection = reader.loadDataFromFile(args[0].trim());
        System.out.println("if you need a help, use command" + ANSI_GREEN + "help" + ANSI_RESET);
        //access the filename passed as an argument
        String fileName = args[0];
        System.out.println("The filename is: " + fileName);
    }
}