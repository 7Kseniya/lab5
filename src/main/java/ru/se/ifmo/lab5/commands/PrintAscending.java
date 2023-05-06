package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Set;
import java.util.TreeSet;

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
        //TODO realization
        commandManager.addToHistory(getCommandName());
        Set<Integer> keySet = new TreeSet<>();
        keySet.addAll(collectionManager.spaceMarineCollection.keySet());

    }
}
