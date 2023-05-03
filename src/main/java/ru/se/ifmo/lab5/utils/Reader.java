package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.LinkedHashMap;

import ru.se.ifmo.lab5.data.SpaceMarine;

/**
 * class for reading csv file
 */
public class Reader {
    /*public void loadFromCSV(CollectionManager collectionManager, String[] args) {
        if (args.length != 1) {
            System.err.println("invalid args");
            System.exit(1);
        }

        String filename = args[0];

        if (!filename.isBlank()) {
            try (CSVReader reader = new CSVReader(new FileReader(filename))) {
                String[] csvData = reader.readNext();
                String csvString = csvData[0];

                // deserialize the csv-formatted string to the collection
                byte[] bytes = csvString.getBytes();
                ByteArrayInputStream bytesToObj = new ByteArrayInputStream(bytes);
                ObjectInputStream objIn = new ObjectInputStream(bytesToObj);
                LinkedHashMap<Integer, SpaceMarine> collection = (LinkedHashMap<Integer, SpaceMarine>) objIn.readObject();
            } catch (FileNotFoundException e) {
                IOHandler.println("file not found");
            } catch (ClassNotFoundException | CsvValidationException e) {
                IOHandler.println("class not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

    /*public LinkedHashMap<Integer, SpaceMarine> loadDataFromFile(String args) {
        LinkedHashMap<Integer, SpaceMarine> collection = new LinkedHashMap<>();
        String fileName = args;
        if (!(fileName.isBlank())) {
            try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(fileName));
                 CSVReader csvReader = new CSVReader(streamReader)) {
                String[] lines;
                while ((lines = csvReader.readNext()) != null) {
                    String csvString = lines[0];
                    byte[] bytes = csvString.getBytes();
                    ByteArrayInputStream bytesToObj = new ByteArrayInputStream(bytes);
                    ObjectInputStream objIn = new ObjectInputStream(bytesToObj);
                    LinkedHashMap<Integer, SpaceMarine> deserializedCollection = (LinkedHashMap<Integer, SpaceMarine>) objIn.readObject();
                    collection = deserializedCollection;
                }
            } catch (FileNotFoundException e) {
                IOHandler.println("file not found");
                System.exit(1);
            } catch (NullPointerException e) {
                IOHandler.println("file is empty");
                System.exit(1);
            } catch (CsvValidationException | IOException e) {
                IOHandler.println("single line in file is invalid");
                System.exit(1);
            } catch (ClassNotFoundException e) {
                IOHandler.println("class is not found");
            }
        }
        return collection;
    }*/
}
