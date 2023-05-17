package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class History extends Command{
    CommandManager commandManager;

    @Override
    public String getCommandName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "show the last 11 commands without arguments";
    }

    /**
     * show history of last 11 commands
     */
    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        if(args == null) IOHandler.println(ANSI_RED + "incorrect command format"+ ANSI_RESET);
        IOHandler.print(ANSI_BLUE + "Last 11 commands: " + ANSI_RESET);
        commandManager.getHistory();

    }
}
