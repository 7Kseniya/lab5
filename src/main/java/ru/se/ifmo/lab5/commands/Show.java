package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

/**
 * show elements
 */
public class Show extends Command{

    @Override
    public String getCommandName() {
        return "show";
    }

    @Override
    String getDescription() {
        return "show all elements in string cast";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if(args.length ==0) throw new NumberOfArgsException();
            collectionManager.show();
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect amount of args" + ANSI_RESET);
        }
    }
}
