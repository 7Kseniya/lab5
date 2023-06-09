package ru.se.ifmo.lab5.utils;

import com.google.common.reflect.ClassPath;
import ru.se.ifmo.lab5.commands.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;
import com.google.common.reflect.ClassPath.ClassInfo;

public class CommandManager {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static HashMap<String, Command> commandMap = new HashMap<>();

    private PriorityQueue<String> commandHistory;
    private Set<String> executedScripts;

    public CommandManager(Set<String> executedScripts, PriorityQueue<String> commandHistory) {
        this.commandHistory = commandHistory;
        this.executedScripts = executedScripts;
    }

    /**
     *parse package and get all classes which extend Command
     * @return list of command classes
     */
    public static List<Class<? extends Command>> getCommandClasses() {
        List<Class<? extends Command>> commands = new ArrayList<>();
        String packageName = "ru.se.ifmo.lab5.commands";
        try {
            List<Class<?>> classes = ClassPath.from(ClassLoader.getSystemClassLoader()).getTopLevelClasses(packageName)
                    .stream()
                    .map(ClassInfo::load)
                    .collect(Collectors.toList());
            for (Class<?> clazz : classes) {
                if (Command.class.isAssignableFrom(clazz)) {
                    commands.add(clazz.asSubclass(Command.class));
                }
            }
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "parse package error" + ANSI_RESET);
        }
        return commands;
    }

    public void getCommandInstance(){
        List<Class<? extends Command>> commandClasses = getCommandClasses();

        for (Class<? extends Command> commandClass : commandClasses) {
            try {
                Command command =(Command) commandClass.getDeclaredConstructor().newInstance();
                commandMap.put(command.getCommandName(), command);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                IOHandler.println("failed to create command instances ([null] means it's all right)" + e.getMessage());
            }
        }
    }

    public boolean hasCommand(String commandName) {
        return commandMap.containsKey(commandName);
    }

    public void executeCommand(CollectionManager collectionManager, CommandManager commandManager, String[] args, BufferedReader reader){
        while (true) {
            try {
                Command command = commandMap.get(args[0]);
                if (command == null) {
                    IOHandler.println(ANSI_RED + "unknown command" + ANSI_RESET);
                } else {
                    //IOHandler.println(Arrays.copyOfRange(args, 1, args.length));
                    if (args.length > 1){
                        command.execute(collectionManager, commandManager, Arrays.copyOfRange(args, 1, args.length));
                    }else{
                        command.execute(collectionManager, commandManager, args);
                    }
                    addToHistory(command.getCommandName());
                    IOHandler.print(ANSI_BLUE + ">> " + ANSI_RESET);
                }
            } catch (Exception e) {
                IOHandler.println(ANSI_RED + "incorrect command parameters \ntry again\n" + ANSI_RESET);
            }
            try {
                args = reader.readLine().toLowerCase().split(" ");
            } catch (IOException e) {
                IOHandler.println(ANSI_RED + "incorrect input" + ANSI_RESET);
            }
        }
    }

    public PriorityQueue<String> getCommandHistory() {
        return commandHistory;
    }
    /**
     * add command to command history collection
     * @param command
     */
    public void addToHistory(String command){
        if (commandHistory.size() == 11) commandHistory.peek();
        commandHistory.add(command);
    }

    public Set<String> getExecutedScripts() {
        return executedScripts;
    }

    public void addExecutedScript(String script){
        executedScripts.add(script);
    }
    public void clearExecutedScripts(){
        executedScripts.clear();
    }
    public void contains(String script){
        executedScripts.contains(script);
    }


}