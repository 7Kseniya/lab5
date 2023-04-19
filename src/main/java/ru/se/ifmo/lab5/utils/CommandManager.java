package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.commands.Command;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandManager {

    /**
     *
     * @return commands from list
     */
    public static List<Class<? extends Command>> getCommandClasses() {
        List<Class<? extends Command>> commands = new ArrayList<>();
        String packageName = "ru.se.ifmo.lab5.commands";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //Package pkg = Package.getPackage(packageName);
        Set<Class<?>> classes;

        {
            try {
                classes = new HashSet<>(Arrays.asList(classLoader.loadClass(packageName).getDeclaredClasses()));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        for(Class<?> clazz : classes) {
            if (Command.class.isAssignableFrom(clazz)) {
                commands.add(clazz.asSubclass(Command.class));
            }
        }
        return commands;
    }

    public void executeCommands(){
        List<Class<? extends Command>> commandClasses = getCommandClasses();

        for (Class<? extends Command> commandClass : commandClasses) {
            Command command = null;
            try {
                command = commandClass.getDeclaredConstructor().newInstance();

            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            //command.execute();
        }

    }


    private LinkedList<String> commandHistory;

    public LinkedList<String> getCommandHistory() {
        return commandHistory;
    }

    /**
     * add command into command history collection
     * @param command
     */
    public void addToHistory(String command){
        if(commandHistory.size() < 11){
            commandHistory.addLast(command);
        }else{
            commandHistory.removeFirst();
        }

    }






}
