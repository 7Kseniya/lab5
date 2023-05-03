package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;

/**
 * show elements
 */
public class Show extends Command{
    private CommandManager commandManager;

    public Show(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    String getCommandName() {
        return "show";
    }

    @Override
    String getDescription() {
        return "show all elements in string cast";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        //TODO implements realization
        collectionManager.show();
    }
}
