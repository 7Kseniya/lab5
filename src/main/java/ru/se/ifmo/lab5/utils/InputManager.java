package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.exceptions.CommandNotFoundException;

import java.io.*;
import java.time.ZonedDateTime;

public class InputManager {
    public static void start(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        CommandManager commandManager = new CommandManager();
        fileManager.inputFile(args);
        commandManager.getCommandInstance();
        handleCommand(commandManager);
    }

    public static void handleCommand(CommandManager commandManager) {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        while (true) {
            try {
                IOHandler.println("> ");
                String[] input = reader.readLine().toLowerCase().split(" ");

                if (!commandManager.hasCommand(input[0])) throw new CommandNotFoundException();
                else {
                    commandManager.executeCommand(new CollectionManager(ZonedDateTime.now()), input, reader);
                    commandManager.addToHistory(input[0]);
                }
            } catch (IOException e) {
                IOHandler.println("there is no such command or your input is incorrect \nenter command 'help' to view available commands" );
                break;
            } catch (CommandNotFoundException e) {
                IOHandler.println("command " + inputStream + "not found \nenter command 'help' to see available list of commands");
            }
        }

    }
}
