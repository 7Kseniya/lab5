package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.Creator;
import ru.se.ifmo.lab5.utils.IOHandler;

/**
 * add an element to collection
 */
public class Insert extends Command {

    @Override
    public String getCommandName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "add a new element with given key to collection";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try{
            Creator creator = new Creator();
            if(args.length == 0) throw new NumberOfArgsException();
            Integer id = collectionManager.generateNextId();
            SpaceMarine spaceMarine = new SpaceMarine(id, creator.createName(), creator.createCoordinates(),
                    creator.createDate(), creator.createHealth(), creator.createLoyal(), creator.chooseAstarters(), creator.chooseMeleeWeapon(), creator.createChapter());
            collectionManager.spaceMarineCollection.put(id, spaceMarine);
            IOHandler.println(ANSI_GREEN + "command " + getCommandName() + " completed successfully" + ANSI_RESET);
        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect number of args" + ANSI_RESET);
        }
    }
}