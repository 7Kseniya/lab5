package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.IOHandler;
import java.util.Arrays;

public class RemoveLowerKey extends Command{
    @Override
    public String getCommandName() {
        return "remove_lower_key";
    }

    @Override
    String getDescription() {
        return "remove elements from collection whose id lower that specified";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if(args.length !=1 || args[0].trim().isEmpty()) throw new NumberOfArgsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.removeLower(id);
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
}
