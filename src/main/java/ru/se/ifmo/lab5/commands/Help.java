package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class Help extends Command {

    CommandManager commandManager;

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "show a list of available commands";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if (!(args.length == 0 | args.toString().trim().isEmpty())) throw new NumberOfArgsException();
            commandManager.addToHistory(getCommandName());
            commandManager.getAllCommands();

        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect number of args" + ANSI_RESET);
        }
    }
}
