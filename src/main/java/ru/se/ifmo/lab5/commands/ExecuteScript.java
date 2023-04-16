package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;
import ru.se.ifmo.lab5.utils.Reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * command which read and execute script from file
 */
public class ExecuteScript extends Command implements Serializable {
    CommandManager commandManager;
    Reader reader;
    @Override
    String getCommandName() {
        return "execute_script";
    }

    @Override
    String getDescription() {
        return "read and execute script from file";
    }
    @Override
    public void register(String commandName, Command command) {
        commandManager.getCommands().put(getCommandName(), getDescription());
    }

    @Override
    void execute(CollectionManager collectionManager, String[] args) {
        try{
            reader.readCSV(args);
            if(reader.readCSV())
        } catch (Exception e) {
            IOHandler.println(" ");
        }


    }
}