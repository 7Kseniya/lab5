package ru.se.ifmo.lab5.utils;

import java.io.*;
import java.time.ZonedDateTime;

public class InputManager {
    public static void start(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        CommandManager commandManager = new CommandManager();
        try{
            fileManager.inputFile(args);
        }catch(FileNotFoundException e){
            IOHandler.println("file not found");
        }

        handleCommand(commandManager);

    }

    public static void handleCommand(CommandManager commandManager) {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        while (true) {
            try {
                IOHandler.println("> ");
                String[] input = reader.readLine().toLowerCase().split(" ");

                if (!commandManager.hasCommand(input[0])) ;
                else {
                    commandManager.executeCommand(new CollectionManager(ZonedDateTime.now()), input, reader);
                    commandManager.addToHistory(input[0]);
                }
            } catch (IOException e) {
                IOHandler.println("there is no such command or your input is incorrect \nenter command 'help' to view available commands" );
                break;
            }
        }

    }
}
