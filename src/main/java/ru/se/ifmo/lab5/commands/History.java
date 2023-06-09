package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class History extends Command{

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
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        if(args.length != 1) IOHandler.println(ANSI_RED + "incorrect command format"+ ANSI_RESET);
        IOHandler.print(ANSI_BLUE + "Last 11 commands: \n" + ANSI_RESET);
        for(String command : commandManager.getCommandHistory()){
            IOHandler.println(ANSI_BLUE + command + ANSI_RESET);
        }
    }
}
