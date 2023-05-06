package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.Creator;
import ru.se.ifmo.lab5.utils.IOHandler;


/**
 * add element in collection
 */

public class Insert extends Command {
    private Creator creator;
    CommandManager commandManager;


    public Insert(Creator creator) {
        this.creator = creator;
    }

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
            if((args.length == 0 | args[0].trim().isEmpty())) throw new NumberOfArgsException();
            SpaceMarine spaceMarine = new SpaceMarine(collectionManager.generateNextId(), creator.createName(), creator.createCoordinates(),
                    creator.createDate(), creator.createHealth(), creator.createLoyal(), creator.chooseAstarters(), creator.chooseMeleeWeapon(), creator.createChapter());
            collectionManager.spaceMarineCollection.put(spaceMarine.getId(), spaceMarine);


        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect number of args" + ANSI_RESET);
        }
    }

}
