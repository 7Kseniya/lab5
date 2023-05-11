package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.Creator;
import ru.se.ifmo.lab5.utils.IOHandler;

/**
 * info about collection: size and initialization date
 */
public class Info extends Command{
    private CommandManager commandManager;
    private Creator creator;

    public Info(Creator creator) {
        this.creator = creator;
    }
    @Override
    String getCommandName() {
        return "info";
    }
    @Override
    String getDescription() {
        return "show information about collection (type, initialization date, amount of elements)";
    }
    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        if(args.length != 1) {
            IOHandler.println(ANSI_RED + "incorrect number of args " + ANSI_RESET);
        }else{
            IOHandler.println(ANSI_BLUE + "number of elements in the collection: " + ANSI_RESET + collectionManager.getSize());
            IOHandler.println(ANSI_BLUE + "collection initialization date: " + ANSI_RESET + collectionManager.getCreationDate());
            IOHandler.print("fields of collection: " + ANSI_MAGENTA);
            collectionManager.getFields();
            commandManager.addToHistory(getCommandName());
        }
    }
}
