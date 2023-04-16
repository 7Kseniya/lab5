package ru.se.ifmo.lab5.commands;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Help extends Command {

    CommandManager commandManager;

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "show a list of available commands";
    }
//    public Set<Class> getCommands(String packageName) {
//        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
//        return reflections.getSubTypesOf(Object.class)
//                .stream()
//                .collect(Collectors.toSet());
//    }

    @Override
    public void register(String commandName, Command command) {
        commandManager.getCommands().put(getCommandName(), getDescription());
    }


    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        try {
            if (!(args.length == 0 | args.toString().trim().isEmpty())) throw new NumberOfArgsException();
            commandManager.addToHistory(getCommandName());

        } catch (NumberOfArgsException e) {
            IOHandler.println(ANSI_RED + "incorrect number of args" + ANSI_RESET);
        }
    }
}
