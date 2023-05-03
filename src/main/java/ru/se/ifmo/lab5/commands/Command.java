package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CommandExecutor;

public abstract class Command implements CommandExecutor {
   /**
    * colors for output modification
    */
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_RESET = "\u001B[0m";
   abstract String getCommandName();
   abstract String getDescription();





}
