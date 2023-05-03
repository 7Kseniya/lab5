package ru.se.ifmo.lab5.commands;


import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class History extends Command{
    CommandManager commandManager;

    public History(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

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
        if(args.length > 0){
            IOHandler.println(ANSI_RED + "incorrect command format"+ ANSI_RESET);
        }else{
            commandManager.addToHistory(getCommandName());
            IOHandler.print(ANSI_GREEN + "Last 11 commands: " + ANSI_RESET);
            for(String c : commandManager.getCommandHistory()){
                IOHandler.println(c);
            }
        }
    }
}
