package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class RemoveGreaterKey extends Command{
    CommandManager commandManager;
    @Override
    public String getCommandName() {
        return "remove_greater_key";
    }

    @Override
    String getDescription() {
        return "remove elements from collection whose id greater than specified";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length == 0 ) throw new NumberOfArgsException();
            if(args.length < 1) throw new ArrayIndexOutOfBoundsException();
            Integer id = Integer.parseInt(Arrays.toString(args));
            collectionManager.removeGreater(id);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect amount of args" + ANSI_RESET);
        } catch (NumberFormatException e){
            IOHandler.println(ANSI_RED + "number format error" + ANSI_RESET);
        }
    }
}
