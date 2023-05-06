package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ru.se.ifmo.lab5.data.SpaceMarine;
import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.LinkedHashMap;

/**
 * class for reading csv file
 */
public class FileManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //private static final String DELIMETER = ",";
    public void inputFile(String[] args) {
        try {
            //check if the filename is passed as an argument
            File fileName = new File(args[0]);
            if (!fileName.exists()) {
                throw new FileNotFoundException();
            } else IOHandler.println(ANSI_GREEN + "your filename is: " + ANSI_RESET + fileName);
            LinkedHashMap<Integer, SpaceMarine> collection = new LinkedHashMap<>();


            //if (!fileName.canRead()) throw new AccessDeniedException(args[0]);
            if (fileName.canRead()) {
                try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(fileName));
                     CSVReader csvReader = new CSVReader(inputStream)) {

                    String[] lines;
                    while ((lines = csvReader.readNext()) != null) {
                        String csvString = lines[0];
                        byte[] bytes = csvString.getBytes();
                        ByteArrayInputStream bytesToObj = new ByteArrayInputStream(bytes);
                        ObjectInputStream objIn = new ObjectInputStream(bytesToObj);
                        collection = (LinkedHashMap<Integer, SpaceMarine>) objIn.readObject();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            IOHandler.println(ANSI_RED + "file not found");
            System.exit(1);
        } catch (NullPointerException e) {
            IOHandler.println(ANSI_RED + "file is empty");
            System.exit(1);
        } catch (CsvValidationException | IOException e) {
            IOHandler.println(ANSI_RED + "line in file is invalid");
            System.exit(1);
        } catch (ClassNotFoundException e) {
            IOHandler.println(ANSI_RED + "class is not found");
        }
    }

            /*String line = "";
            String[] spaceMarArg;
            while ((line = reader.readLine()) != null) {
                spaceMarArg = line.split(DELIMETER);

                SpaceMarine spaceMarine
                        = new SpaceMarine(Integer.parseInt(spaceMarArg[0]),
                        spaceMarArg[1],
                        new Coordinates(Float.parseFloat(spaceMarArg[2]), Long.parseLong(spaceMarArg[3])),
                        ZonedDateTime.now(),
                        Integer.parseInt(spaceMarArg[4]),
                        Boolean.parseBoolean(spaceMarArg[5]),
                        new AstartesCategory(AstartesCategory.valueOf(spaceMarArg[6])),
                        new MeleeWeapon(MeleeWeapon.valueOf(spaceMarArg[7])),
                        new Chapter(spaceMarArg[8], Integer.parseInt(spaceMarArg[9]), spaceMarArg[10]));
                //collectionManager.add(spaceMarine);
            }*/

        //reader.close();
/*        } catch (AccessDeniedException e) {
            IOHandler.println("access denied");*/
        /*} catch (FileNotFoundException e){
            IOHandler.println(ANSI_RED + "Please provide the filename as an argument." + ANSI_RESET);

        }*/
}
