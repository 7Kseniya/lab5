package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Arrays;

public class FilterByHealth extends Command{
    CommandManager commandManager;
    @Override
    public String getCommandName() {
        return "filter_by_health";
    }
    @Override
    String getDescription() {
        return "output collection elements whose health value equals specified";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if(args.length !=1 || args[0].trim().isEmpty()) throw new NumberOfArgsException();
            Integer health = Integer.parseInt(Arrays.toString(args));
            IOHandler.println(ANSI_BLUE + "collection element with health == " + health + ANSI_RESET);
            collectionManager.filterByHealth(health);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect amount of args" + ANSI_RESET);
        }
    }
}
