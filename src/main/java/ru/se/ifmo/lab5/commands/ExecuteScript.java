package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;
import ru.se.ifmo.lab5.utils.Reader;

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
    void execute(CollectionManager collectionManager, String[] args) {
//        String scriptFilename = args[0];
//        if (!scriptFile.exists() || !scriptFile.isFile()) {
//            System.err.println("Error: script file does not exist or is not a regular file");
//            System.exit(1);
//        }


    }

    @Override
    public void register(String commandName, Command command) {

    }
}