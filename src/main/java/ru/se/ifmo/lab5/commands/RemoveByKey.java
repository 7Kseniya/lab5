package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class RemoveByKey extends Command{
    CommandManager commandManager;
    @Override
    public String getCommandName() {
        return "remove_by_key";
    }

    @Override
    String getDescription() {
        return "remove element of collection by id";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length == 0 ) throw new NumberOfArgsException();
            if(args.length < 1) throw new ArrayIndexOutOfBoundsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.removeById(id);
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
}
