package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class PrintAscending extends Command{
    CommandManager commandManager;
    @Override
    public String getCommandName() {
        return "print_ascending";
    }

    @Override
    String getDescription() {
        return "print collection elements in ascending order";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length != 0 ) throw new NumberOfArgsException();
            collectionManager.printAscending();
            IOHandler.println("element removed");
        } catch (NumberOfArgsException e) {
            IOHandler.println("incorrect amount of args");
        }
    }
}
