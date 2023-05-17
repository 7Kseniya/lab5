package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;

public  interface CommandExecutor {
    void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) throws NumberOfArgsException;
}
