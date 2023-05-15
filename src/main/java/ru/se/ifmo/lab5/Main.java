package ru.se.ifmo.lab5;

import ru.se.ifmo.lab5.utils.InputManager;
import java.io.IOException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws IOException {
        System.out.println("if you need a help, use command" + ANSI_GREEN + "help" + ANSI_RESET);
        InputManager.start(args);
    }
}