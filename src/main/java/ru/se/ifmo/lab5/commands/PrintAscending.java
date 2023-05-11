package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class PrintAscending extends Command{
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "print_ascending";
    }

    @Override
    String getDescription() {
        return "print collection elements in ascending order";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        if(args.length != 0) try {
            throw new NumberOfArgsException();
        } catch (NumberOfArgsException e) {
            throw new RuntimeException(e);
        }
        else{
            collectionManager.printAscending();
        }
    }
}
