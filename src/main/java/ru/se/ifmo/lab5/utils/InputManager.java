package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.data.SpaceMarine;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;

public class InputManager {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void start(String[] args) {
        FileManager fileManager = new FileManager();
        CommandManager commandManager = new CommandManager();
        LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection = new LinkedHashMap<>();
        CollectionManager collectionManager = new CollectionManager(spaceMarineCollection, ZonedDateTime.now());
        fileManager.inputFile(collectionManager, args);
        commandManager.getCommandInstance();
        handleCommand(collectionManager, commandManager);
    }

    public static void handleCommand(CollectionManager collectionManager, CommandManager commandManager) {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        while (true) {
            try {
                IOHandler.print(">> ");

                String[] input = reader.readLine().toLowerCase().trim().split(" ");

//                if (!commandManager.hasCommand(input[0])) throw new CommandNotFoundException();
//                else {
                    commandManager.executeCommand(collectionManager, input, reader);
                    commandManager.addToHistory(String.join(" ", input[0]));

//                    commandManager.addToHistory(input[0]);
//                }
            } catch (IOException e) {
                IOHandler.println("there is no such command or your input is incorrect \nenter command" + ANSI_BLUE + "help" + ANSI_RESET + "to view available commands" );
//            } catch (CommandNotFoundException e) {
//                IOHandler.println("command not found \nenter command 'help' to see available list of commands");
//                break;
            }
        }
    }
}
