package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class RemoveGreaterKey extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "remove_greater_key";
    }

    @Override
    String getDescription() {
        return "remove elements from collection whose id greater than specified";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if(args.length !=1 || args[0].trim().isEmpty()) throw new NumberOfArgsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.removeGreater(id);
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
    }
}
