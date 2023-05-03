package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.Reader;

import java.util.LinkedList;

public class MaxByMeleeWeapon extends Command {
    CommandManager commandManager;
    @Override
    String getCommandName() {
        return "max_by_melee_weapon";
    }

    @Override
    String getDescription() {
        return "outputs collection element whose melee weapon value is max";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {

    }

}
