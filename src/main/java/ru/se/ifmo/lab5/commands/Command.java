package ru.se.ifmo.lab5.commands;

import ru.se.ifmo.lab5.utils.CommandExecutor;

import java.io.Serializable;

public abstract class Command implements Serializable, CommandExecutor {
   /**
    * colors for output modification
    */
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_MAGENTA = "\u001B[35m";
   public static final String ANSI_CYAN = "\u001B[36m";


   abstract public String getCommandName();
   abstract String getDescription();

}
