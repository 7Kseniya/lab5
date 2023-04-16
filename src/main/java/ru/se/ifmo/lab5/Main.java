package ru.se.ifmo.lab5;

import ru.se.ifmo.lab5.commands.Clear;
import ru.se.ifmo.lab5.commands.*;
import ru.se.ifmo.lab5.commands.Help;
import ru.se.ifmo.lab5.commands.History;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;
import ru.se.ifmo.lab5.utils.Reader;

import java.io.IOException;
import java.util.LinkedList;

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
        reader.readCSV(args[0].trim());
        System.out.println("if you need a help, use command" + ANSI_GREEN + "help" + ANSI_RESET);
        //access the filename passed as an argument
        String fileName = args[0];
        System.out.println("The filename is: " + fileName);







    }
}