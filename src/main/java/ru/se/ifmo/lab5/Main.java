package ru.se.ifmo.lab5;

import com.opencsv.exceptions.CsvValidationException;
import ru.se.ifmo.lab5.utils.IOHandler;
import ru.se.ifmo.lab5.utils.InputManager;
import java.io.IOException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";


    public static void main(String[] args) throws IOException {
        System.out.println("if you need a help, use command " + ANSI_BLUE + "help" + ANSI_RESET);
        try {
            InputManager.start(args);
        } catch (CsvValidationException e) {
            IOHandler.println(ANSI_RED + "csv validation exception" + ANSI_RESET);
        }
    }
}