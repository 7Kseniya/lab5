package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.commands.Command;

public  interface CommandRegistrar {
    void register(String commandName, Command command);
}
