package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.utils.*;

import java.io.IOException;

public class Save extends Command{
    CommandManager commandManager;

    @Override
    String getCommandName() {
        return "save";
    }

    @Override
    String getDescription() {
        return "save collection to file";
    }
    @Override
    public void register(String commandName, Command command) {
        commandManager.getCommands().put(getCommandName(), getDescription());
    }

    @Override
    void execute(CollectionManager collectionManager, String[] args) {
        if(!(args.length == 0 | args.toString().trim().isEmpty())){
            try{
                Writer writer = new Writer();
                writer.writeCSV(collectionManager, args);
                IOHandler.println("collection successfully saved");
                commandManager.addToHistory(getCommandName());
            } catch (IOException e) {
                IOHandler.println("failed to save collection");
            }

        }


    }
}
