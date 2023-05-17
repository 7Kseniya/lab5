package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import ru.se.ifmo.lab5.data.*;
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
    //LinkedHashMap<Integer, SpaceMarine> spaceMarineCollection = new LinkedHashMap<>();
    public void inputFile(CollectionManager collectionManager, String[] args){
        try {
            //check if the filename is passed as an argument
            File fileName = new File(args[0].strip());
            if (!fileName.exists()) throw new FileNotFoundException();
            if(!fileName.canRead()) IOHandler.println(ANSI_RED + "access denied" + ANSI_RESET);
            IOHandler.println("your filename is: " + ANSI_GREEN + fileName + ANSI_RESET);
            try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
                //String[] headers = csvReader.readNext();
                String[] fields;
                while ((fields = csvReader.readNext()) != null) {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].strip();
                    float x = Float.parseFloat(fields[2].trim());
                    long y = Long.parseLong(fields[3].trim());
                    int health = Integer.parseInt(fields[4].trim());
                    boolean loyal = Boolean.parseBoolean(fields[5].trim().toUpperCase());
                    String category = fields[6].trim().toUpperCase();
                    String weapon = fields[7].trim().toUpperCase();
                    String chapterName = fields[8].strip();
                    int marinesCount = Integer.parseInt(fields[9].trim());
                    String world = fields[10].trim();

                    SpaceMarine spaceMarine = new SpaceMarine(
                            id, name,
                            new Coordinates(x, y),
                            ZonedDateTime.now(),
                            health, loyal,
                            AstartesCategory.valueOf(category),
                            MeleeWeapon.valueOf(weapon),
                            new Chapter(chapterName, marinesCount, world));
                    collectionManager.getSpaceMarineCollection().put(id, spaceMarine);
                }
            }

            IOHandler.println("collection size: " + collectionManager.getSize());
            IOHandler.println("collection successfully loaded");

        } catch (FileNotFoundException e) {
            IOHandler.println(ANSI_RED + "file " + args[0] + "not found" + ANSI_RESET);
        } catch (IOException | CsvValidationException e) {
            IOHandler.println(ANSI_RED + "error reading file: " + e.getMessage() + ANSI_RESET);
        } catch (IllegalArgumentException e) {
            IOHandler.println(ANSI_RED + "error parsing CSV data: " + e.getMessage() + ANSI_RESET);
        } catch (ArrayIndexOutOfBoundsException e){
            IOHandler.println("array index out of bounds");
        }
    }


   /* public static void writeCollectionToCsv(LinkedHashMap<Integer, SpaceMarine> collection, String fileName) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
            for (SpaceMarine spaceMarine : collection.values()) {
                StringBuilder sb = new StringBuilder();
                sb.append(spaceMarine.getName()).append(",")
                        .append(spaceMarine.getCoordinates().getX()).append(",")
                        .append(spaceMarine.getCoordinates().getY()).append(",")
                        .append(spaceMarine.getCreationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append(",")
                        .append(spaceMarine.getHealth()).append(",")
                        .append(spaceMarine.getLoyal()).append(",")
                        .append(spaceMarine.getCategory()).append(",")
                        .append(spaceMarine.getMeleeWeapon()).append(",")
                        .append(spaceMarine.getChapter().getName()).append(",")
                        .append(spaceMarine.getChapter().getMarinesCount()).append(",")
                        .append(spaceMarine.getChapter().getWorld());
                sb.append("\n");
                outputStream.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }*/

}



            //if (!fileName.canRead()) throw new AccessDeniedException(args[0]);
  /*          if (fileName.canRead()) {
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
    }*/

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
