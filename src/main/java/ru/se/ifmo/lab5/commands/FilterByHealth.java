package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class FilterByHealth extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "filter_by_health";
    }

    @Override
    String getDescription() {
        return "output collecction elements whose health value equals specified";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {

    }
}
