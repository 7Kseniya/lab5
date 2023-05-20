package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

public class MaxByMeleeWeapon extends Command {
    @Override
    public String getCommandName() {
        return "max_by_melee_weapon";
    }

    @Override
    String getDescription() {
        return "outputs collection element whose melee weapon value is max";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        try {
            if (args.length == 0) throw new NumberOfArgsException();
            collectionManager.maxByMeleeWeapon();

        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect amount of args" + ANSI_RESET);
        }
    }
}
