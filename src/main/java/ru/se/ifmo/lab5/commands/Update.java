package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.Creator;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Update extends Command{
    @Override
    public String getCommandName() {
        return "update";
    }

    @Override
    String getDescription() {
        return "update collection element value";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length == 0) throw new NumberOfArgsException();
            Integer id = Integer.parseInt(args[0]);
            collectionManager.update(id);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect amount of args" + ANSI_RESET);
        } catch (NumberFormatException e){
            IOHandler.println(ANSI_RED + "number format error" + ANSI_RESET);
        }
    }
}
