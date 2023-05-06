package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Clear extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "clear";
    }

    @Override
    String getDescription() {
        return "clear collection";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        collectionManager.clear();
        IOHandler.println("collection cleared");

    }
}
