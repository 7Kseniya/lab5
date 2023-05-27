package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Exit extends Command{
    @Override
    public String getCommandName() {
        return "exit";
    }

    @Override
    String getDescription() {
        return "terminate program";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        System.exit(0);
    }
}
