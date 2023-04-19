package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Exit extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "exit";
    }

    @Override
    String getDescription() {
        return "terminate program";
    }
    @Override
    public void register(String commandName, Command command) {
        //commandManager.getCommands().put(getCommandName(), getDescription());
    }

    @Override
    void execute(CollectionManager collectionManager, String[] args) {
        System.exit(0);
        IOHandler.println("program terminate successfully");


    }
}
