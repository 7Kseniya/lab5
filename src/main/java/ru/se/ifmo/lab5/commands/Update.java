package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class Update extends Command{
    @Override
    public String getCommandName() {
        return "update";
    }

    @Override
    String getDescription() {
        return "update collection element value";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length !=1 || args[0].trim().isEmpty()) throw new NumberOfArgsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.update(id);
            IOHandler.println("collection element updated successfully");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
}
