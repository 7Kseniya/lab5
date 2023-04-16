package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class RemoveLowerKey extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "remove_lower_key";
    }

    @Override
    String getDescription() {
        return "remove elements from collection whose id lower that specified";
    }

    @Override
    void execute(CollectionManager collectionManager, String[] args) {
        //TODO implements realization
        //collectionManager.removeLower();
    }

    @Override
    public void register(String commandName, Command command) {
        commandManager.getCommands().put(getCommandName(), getDescription());
    }
}
