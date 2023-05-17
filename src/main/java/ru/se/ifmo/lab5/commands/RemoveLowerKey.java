package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

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
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length == 0 ) throw new NumberOfArgsException();
            if(args.length < 1) throw new ArrayIndexOutOfBoundsException();
            Integer id = Integer.parseInt(args[0]);
            collectionManager.removeLower(id);
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        } catch (NumberFormatException e){
            IOHandler.println("number format error");
        }
    }
}
