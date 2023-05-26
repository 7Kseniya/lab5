package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ru.se.ifmo.lab5.data.*;
import ru.se.ifmo.lab5.exceptions.InvalidValueException;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;

/**
 * class for reading csv file
 */
public class FileManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public void inputFile(CollectionManager collectionManager, String[] args) {
        try {
            File fileName = new File(args[0].strip());
            if (!fileName.exists()) throw new FileNotFoundException();
            if (!fileName.canRead()) IOHandler.println(ANSI_RED + "access denied" + ANSI_RESET);
            IOHandler.println("your filename is: " + ANSI_GREEN + fileName + ANSI_RESET);
            try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
                //String[] headers = csvReader.readNext();
                String[] fields;

                while ((fields = csvReader.readNext()) != null ) {
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
            }
        } catch (FileNotFoundException e) {
            IOHandler.println(ANSI_RED + "file " + args[0] + "not found" + ANSI_RESET);
        } catch (IOException | CsvValidationException e) {
            IOHandler.println(ANSI_RED + "error reading file: " + e.getMessage() + ANSI_RESET);
        } catch (IllegalArgumentException e) {
            IOHandler.println(ANSI_RED + "error parsing CSV data: " + e.getMessage() + ANSI_RESET);
        } catch (ArrayIndexOutOfBoundsException e) {
            IOHandler.println("array index out of bounds");
        }
    }
}