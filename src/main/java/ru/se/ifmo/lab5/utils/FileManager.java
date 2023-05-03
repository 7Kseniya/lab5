package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.data.*;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FileManager {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String DELIMETER = ",";
    public void inputFile(String[] args) throws IOException, AccessDeniedException {
        try{
            //check if the filename is passed as an argument
            File fileName = new File(args[0]);
            if (!fileName.exists()){
                throw new FileNotFoundException();
            }
            Creator creator = new Creator();
            creator.createSpaceMarine();
            //if (!fileName.canRead()) throw new AccessDeniedException(args[0]);
            IOHandler.println(ANSI_GREEN + "your filename is: " + ANSI_RESET + fileName);
/*          InputStream input = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
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
        } catch (FileNotFoundException e){
            IOHandler.println(ANSI_RED + "Please provide the filename as an argument." + ANSI_RESET);

        }

    }

}
