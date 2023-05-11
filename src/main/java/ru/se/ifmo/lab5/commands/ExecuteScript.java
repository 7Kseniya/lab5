package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.exceptions.RecursiveScriptException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.io.*;

/**
 * command which read and execute script from file
 */
public class ExecuteScript extends Command implements Serializable {
    @Override
    String getCommandName() {
        return "execute_script";
    }

    @Override
    String getDescription() {
        return "read and execute script from file";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {
        if(args[0].isEmpty()) IOHandler.println("write correct filename");

        File scriptFile = new File(args[0]);
        if (!scriptFile.exists() || !scriptFile.isFile()) {
            System.err.println("Error: script file does not exist or is not a regular file");
            System.exit(1);
        }else if(scriptFile.exists() && !scriptFile.canRead()){
            IOHandler.println("no permission to read this file");
        }else{
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scriptFile)))) {
                String line;
                while ((reader.readLine()) != null) {
                    line = reader.readLine().toLowerCase();
                    if (line.startsWith("execute_script")) {
                        throw new RecursiveScriptException();
                    }
                }
            } catch (IOException e) {
                IOHandler.println(" ");
            }
        }
    }
}