package ru.se.ifmo.lab5.commands;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ru.se.ifmo.lab5.data.*;
import ru.se.ifmo.lab5.exceptions.NumberOfArgsException;
import ru.se.ifmo.lab5.exceptions.RecursiveScriptException;
import ru.se.ifmo.lab5.utils.CollectionManager;
import ru.se.ifmo.lab5.utils.CommandManager;
import ru.se.ifmo.lab5.utils.IOHandler;

import java.io.*;
import java.time.ZonedDateTime;
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

        File scriptFile = new File(args[0].trim());
        if (!scriptFile.exists() || !scriptFile.isFile()) {
            IOHandler.println(ANSI_RED + "Error: script file does not exist or is not a regular file" + ANSI_RESET);
        }else if(scriptFile.exists() && !scriptFile.canRead()){
            IOHandler.println(ANSI_RED + "no permission to read this file" + ANSI_RESET);
        }else{
            if(commandManager.getExecutedScripts().contains(String.valueOf(scriptFile))){
                IOHandler.println(ANSI_RED + "file contains command " + getCommandName() + ANSI_RESET);
                return;
            }else commandManager.addExecutedScript(String.valueOf(scriptFile));
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scriptFile)))) {
                String[] line;
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    line = currentLine.toLowerCase().split("\\s+");
                    try {
                        Command command = commandMap.get(line[0]);
                        if (command == null) {
                            IOHandler.println("unknown command");
                        } else {
                            IOHandler.println(Arrays.copyOfRange(line, 1, line.length));
                            if (line.length > 1) {
                                command.execute(collectionManager, commandManager, Arrays.copyOfRange(line, 1, line.length));
                            } else if (line[0].equals("insert")){
                                try (CSVReader csvReader = new CSVReader(new StringReader(reader.readLine()))) {
                                    String[] fields;
                                    if ((fields = csvReader.readNext()) != null) {
                                        int id = Integer.parseInt(fields[0].trim());
                                        String name = fields[1].strip();
                                        float x = Float.parseFloat(fields[2].trim());
                                        long y = Long.parseLong(fields[3].trim());
                                        int health = Integer.parseInt(fields[4].trim());
                                        boolean loyal = Boolean.parseBoolean(fields[5].trim().toLowerCase());
                                        String category = fields[6].trim().toUpperCase();
                                        String weapon = fields[7].trim().toUpperCase();
                                        String chapterName = fields[8].strip();
                                        int marinesCount = Integer.parseInt(fields[9].trim());
                                        String world = fields[10].trim();

                                        if((id > 0) && (x>345 && y>-975) && (health>0) && (marinesCount > 0) && (marinesCount < 1000) && !(name.isEmpty()||chapterName.isEmpty()||world.isEmpty())) {
                                            SpaceMarine spaceMarine = new SpaceMarine(
                                                    id, name,
                                                    new Coordinates(x, y),
                                                    ZonedDateTime.now(),
                                                    health, loyal,
                                                    AstartesCategory.valueOf(category),
                                                    MeleeWeapon.valueOf(weapon),
                                                    new Chapter(chapterName, marinesCount, world));
                                            collectionManager.getSpaceMarineCollection().put(id, spaceMarine);
                                            IOHandler.println(ANSI_BLUE + "collection size: " + collectionManager.getSize() + ANSI_RESET);
                                            IOHandler.println(ANSI_GREEN + "collection successfully loaded" + ANSI_RESET);
                                        }else IOHandler.println(ANSI_RED + "invalid data format \ncollection not loaded" + ANSI_RESET);
                                    }
                                } catch (CsvValidationException e) {
                                    IOHandler.println(ANSI_RED + "error reading fields: " + e.getMessage() + ANSI_RESET);
                                }

                            }
                            else {
                                command.execute(collectionManager, commandManager, line);
                            }
                            commandManager.addToHistory(line[0]);
                        }
                    } catch (NumberOfArgsException e) {
                        IOHandler.println(ANSI_RED + "incorrect command parameters \ntry again\n" + e.getMessage() + ANSI_RESET);
                    }
                }
                commandManager.clearExecutedScripts();
            } catch (IOException e) {
                IOHandler.println(ANSI_RED + "error reading file: " + e.getMessage() + ANSI_RESET);
            } catch (NullPointerException e){
                IOHandler.println(ANSI_RED + "script file is empty" + ANSI_RESET);
            }
        }
    }
}