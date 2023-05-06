package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Update extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "update";
    }

    @Override
    String getDescription() {
        return "update collection element value";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        //TODO implements realization
        //collectionManager.update();
    }
}
