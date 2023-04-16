package ru.se.ifmo.lab5.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ru.se.ifmo.lab5.data.SpaceMarine;
import java.io.*;
import java.util.LinkedHashMap;

/**
 * class for writing collection to csv file
 */
public class Writer {
    public void writeCSV(CollectionManager collectionManager, String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("invalid args");
            System.exit(1);
        }

        String filename = args[0];

        if (!(filename.isBlank())) {
            try {
                OutputStreamWriter streamWriter = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(filename)));
                CSVWriter CSVwriter = new CSVWriter(streamWriter);
                //serialization collection to a csv-formatted string
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                ObjectOutputStream bytesToObj = new ObjectOutputStream(bytes);
                bytesToObj.writeObject(collectionManager.getCollection());

                String[] csvData = new String[]{bytes.toString()};

                CSVwriter.writeNext(csvData);
            } catch (FileNotFoundException e) {
                IOHandler.println("file not found");

            }
        }
    }

}
