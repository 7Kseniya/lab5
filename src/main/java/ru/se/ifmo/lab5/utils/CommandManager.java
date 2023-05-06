package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandManager {
    /**
     *parse package and get all classes which extend Command
     * @return list of command.class
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

    public void getCommandInstance(){
        List<Class<? extends Command>> commandClasses = getCommandClasses();

        for (Class<? extends Command> commandClass : commandClasses) {
            try {
                commandClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                IOHandler.println("");
            }
        }
    }
    HashMap<String, Command> commandMap = new HashMap();

    public void addCommands(Command command) {
        commandMap.put(command.getClass().getName(), command);
    }

    public boolean hasCommand(String commandName) {
        return commandMap.containsKey(commandName);
    }

    public Collection<Command> getAllCommands() {
        return commandMap.values();
    }
    public void executeCommand(CollectionManager collectionManager, String[] args, BufferedReader reader){
        while (true){
            try{
                getCommandInstance();
                commandMap.get(args[0]).execute(collectionManager, args);
                break;
            } catch (Exception e) {
                IOHandler.println("incorrect command parameters \ntry again");
            }
            try {
                reader.readLine().toLowerCase().split(" ");
            } catch (IOException e) {
                IOHandler.println("incorrect input");
            }
        }
    }
    private PriorityQueue<String> commandHistory;
    public PriorityQueue<String> getCommandHistory() {
        return commandHistory;
    }
    /**
     * add command to command history collection
     * @param command
     */
    public void addToHistory(String command){
        if (commandHistory.size() == 11) {
            commandHistory.poll();
        }
        commandHistory.add(command);
    }
    public String getHistory() {
        StringBuilder temp = new StringBuilder();
        for (String string : getCommandHistory())
            temp.append(string).append("\n");
        return temp.toString();
    }












}
