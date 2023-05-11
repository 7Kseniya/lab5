package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.exceptions.InvalidValueException;
import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class RemoveByKey extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "remove_by_key";
    }

    @Override
    String getDescription() {
        return "remove element of collection by id";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if(args.length !=1 || args[0].trim().isEmpty()) throw new NumberOfArgsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.removeById(id);
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
}
