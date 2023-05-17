package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.*;

public class Save extends Command{


    @Override
    public String getCommandName() {
        return "save";
    }

    @Override
    String getDescription() {
        return "save collection to file";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if (args.length == 0) {
                throw new NumberOfArgsException();
            }
            collectionManager.save();
            IOHandler.println(ANSI_GREEN + "collection successfully saved to file " + "" + ANSI_RESET);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "file is not exist" + ANSI_RESET);
        }
    }
}
