package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import ru.se.ifmo.lab5.utils.IOHandler;

/**
 * class for reading csv file
 */
public class Reader {
    public LinkedList<String[]> readCSV(String args) {
        LinkedList<String[]> list = new LinkedList<>();
        String fileName = args;
        if (!(fileName.isBlank())) {
            try (InputStreamReader streamReader = new InputStreamReader(new FileInputStream(fileName));
                 CSVReader csvReader = new CSVReader(streamReader)) {
                String[] lines;
                while ((lines = csvReader.readNext()) != null) {
                    list.add(lines);
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
            }
        }
        return list;
    }
}
