package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Clear extends Command{
    @Override
    public String getCommandName() {
        return "clear";
    }

    @Override
    String getDescription() {
        return "clear collection";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        collectionManager.clear();
        IOHandler.println(ANSI_GREEN + "collection cleared" + ANSI_RESET);
    }
}
