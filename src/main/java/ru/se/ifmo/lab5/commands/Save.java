package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.data.SpaceMarine;
import ru.se.ifmo.lab5.utils.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Save extends Command{


    @Override
    String getCommandName() {
        return "save";
    }

    @Override
    String getDescription() {
        return "save collection to file";
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args) {

    }
        /*if(!(args.length == 0 | args.toString().trim().isEmpty())){
            try{
                Writer writer = new Writer();
                writer.writeCSV(collectionManager, args);
                IOHandler.println("collection successfully saved");
                commandManager.addToHistory(getCommandName());
            } catch (IOException e) {
                IOHandler.println("failed to save collection");
            }

        }*/


    }
