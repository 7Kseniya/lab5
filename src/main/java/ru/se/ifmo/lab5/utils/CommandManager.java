package ru.se.ifmo.lab5.utils;

import java.util.HashMap;
import java.util.LinkedList;
public class CommandManager {
    public CommandManager(LinkedList<String> commandHistory) {
        this.commandHistory = commandHistory;
    }

    private final HashMap<String, String> commands= new HashMap<>();

    /**
     * command collection
     * @return commands
     */
    public HashMap<String, String> getCommands(){
        return commands;
    }
    public void commandsToString(){
        for(String commandName : commands.values()){
            IOHandler.println(commandName);
        }
    }
    /*public void executeAdd(String[] commandName){
        try{
            if(commandName.length>0){
                String command = commands.get(commandName[0]);

            }else{
                IOHandler.println("command not entered");
            }
        }catch (IllegalStateException | NullPointerException e){
            if(!commandName[0].isEmpty() && commandName[0].equals("execute_script")){
                IOHandler.println("command doesn't exist");
            }
        }
    }*/

//    public Set<Class<? extends Command>> SubTypes(String packageName) {
//        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
//        return reflections.getSubTypesOf(Object.class)
//                .stream()
//                .filter()
//                .collect(Collectors.toSet());
//    }

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
