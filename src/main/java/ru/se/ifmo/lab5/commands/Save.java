package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.*;

import java.io.FileNotFoundException;

public class Save extends Command{


    @Override
    String getCommandName() {
        return "save";
    }

    @Override
    String getDescription() {
        return "save collection to file";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if (args.length == 0) {
                throw new NumberOfArgsException();
            }
            collectionManager.save(args[0].trim());
            IOHandler.println(ANSI_GREEN + "collection successfully saved to file " + args[0] + ANSI_RESET);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "file is not exist" + ANSI_RESET);
        }
    }
}
