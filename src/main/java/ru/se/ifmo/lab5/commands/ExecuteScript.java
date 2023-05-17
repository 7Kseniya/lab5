package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.exceptions.RecursiveScriptException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.io.*;
import java.util.Arrays;

import static ru.se.ifmo.lab5.utils.CommandManager.commandMap;

/**
 * command which read and execute script from file
 */
public class ExecuteScript extends Command implements Serializable {
    @Override
    public String getCommandName() {
        return "execute_script";
    }

    @Override
    String getDescription() {
        return "read and execute script from file";
    }

    @Override
    public void execute(CollectionManager collectionManager, CommandManager commandManager, String[] args) {
        if(args[0].isEmpty()) IOHandler.println(ANSI_RED + "write correct filename" + ANSI_RESET);

        File scriptFile = new File(args[0]);
        if (!scriptFile.exists() || !scriptFile.isFile()) {
            IOHandler.println(ANSI_RED + "Error: script file does not exist or is not a regular file" + ANSI_RESET);
        }else if(scriptFile.exists() && !scriptFile.canRead()){
            IOHandler.println(ANSI_RED + "no permission to read this file" + ANSI_RESET);
        }else{
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scriptFile)))) {
                String[] line;
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    line = currentLine.toLowerCase().split("\\s+");
                    if (Arrays.toString(line).startsWith("execute_script")) {
                        IOHandler.println(ANSI_RED + "file contains command " + getCommandName() + ANSI_RESET);
                        return;
                    }
                    try {
                        Command command = commandMap.get(line[0]);
                        if (command == null) {
                            IOHandler.println("unknown command");
                        } else {
                            IOHandler.println(Arrays.copyOfRange(line, 1, line.length));
                            if (line.length > 1) {
                                command.execute(collectionManager, commandManager, Arrays.copyOfRange(line, 1, line.length));
                            } else {
                                command.execute(collectionManager, commandManager, line);
                            }
                            commandManager.addToHistory(line[0]);
                        }
                    } catch (NumberOfArgsException e) {
                        IOHandler.println(ANSI_RED + "incorrect command parameters \ntry again\n" + e.getMessage() + ANSI_RESET);
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                IOHandler.println(" ");
            } catch (NullPointerException e){
                IOHandler.println(ANSI_RED + "script file is empty" + ANSI_RESET);
            }
        }
    }
}