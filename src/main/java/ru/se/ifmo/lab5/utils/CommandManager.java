package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.commands.Command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CommandManager {


    public static List<Class<? extends Command>> getClasses() {
        List<Class<? extends Command>> commands = new ArrayList<>();
        String packageName = "ru.se.ifmo.lab5.commands";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Package pkg = Package.getPackage(packageName);
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
    /*public CommandManager(LinkedList<String> commandHistory) {
        this.commandHistory = commandHistory;
    }

    private List<String> commands= new ArrayList<>();


    public List<String> getCommands(Class<Command> commandClass){
        Class<?>[]
        return commands;
    }

    public void executeCommands(){
        for(Command command : commands){
            command.register();

        }
    }*/


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
