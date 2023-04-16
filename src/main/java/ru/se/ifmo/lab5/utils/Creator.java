package ru.se.ifmo.lab5.utils;

import ru.se.ifmo.lab5.data.*;
import ru.se.ifmo.lab5.exceptions.InvalidValueException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.*;

/**
 * class for creation objects of class SpaceMarine
 */
public class Creator {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(reader);

    /**
     * throw IncorrectValueException if the values don't fit the constraints
     * @return String name
     */
    public String createName() {
        String name;
        try{
            IOHandler.println(ANSI_BLUE + "enter your name:" + ANSI_RESET);
            name = bufferedReader.readLine();
            if(name.trim().isEmpty()) throw new InvalidValueException();
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "" + ANSI_RESET);
            name = createName();
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "name can't be empty" + ANSI_RESET);
            name = createName();
        }
        return name;
    }

    /**
     * throw IncorrectValueException if the values don't fit the constraints
     * @return ru.se.ifmo.lab5.data.Coordinates
     */
    public Coordinates createCoordinates(){
        float x = 0;
        long y = 0;
        Coordinates coordinates;
        try{
            IOHandler.println(ANSI_BLUE + "enter coordinates: \nx = " + ANSI_RESET);
            x = Float.parseFloat(bufferedReader.readLine().trim());
            IOHandler.println("y = ");
            y = Long.parseLong(bufferedReader.readLine().trim());
            if(x<345 || y<-975) throw new InvalidValueException();
            coordinates = new Coordinates(x, y);
        } catch (NumberFormatException | IOException e) {
            IOHandler.println(ANSI_RED + "invalid data format" + ANSI_RESET);
            coordinates = createCoordinates();
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "'x' must be over 345 and 'y' must be over -975" + ANSI_RESET);
            coordinates = createCoordinates();
        }
        return coordinates;
    }

    //ISO-8601 calendar system: 2007-12-03T10:15:30+01:00 Europe/Paris

    public ZonedDateTime createDate() {
        ZonedDateTime creationDate;
        try {
            creationDate = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = creationDate.format(formatter);
            String pattern = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
            if (formattedDateTime.matches(pattern)) {
                IOHandler.println("creation date format is " + creationDate);
            } else {
                throw new InvalidValueException();
            }
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "invalid creation date format" + ANSI_RESET);
            creationDate = createDate();
        }

        return creationDate;
    }

    /**
     * choose astarters category
     * @return ru.se.ifmo.lab5.data.AstartesCategory
     */

    public AstartesCategory chooseAstarters(){
        AstartesCategory category = null;
        try{
            IOHandler.println(ANSI_BLUE + "choose astarters category from the list:" + ANSI_RESET+
                    "\nSCOUT \nLIBRARIAN \nCHAPLAIN");
            category = AstartesCategory.valueOf(bufferedReader.readLine().trim().toUpperCase());
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "" + ANSI_RESET);
            category = chooseAstarters();
        } catch (IllegalArgumentException e){
            IOHandler.println(ANSI_RED + "entered non-existent value \nchoose from the options" + ANSI_RESET);
        }
        return category;
    }

    /**
     * choose melee weapon
     * @return ru.se.ifmo.lab5.data.MeleeWeapon
     */
    public MeleeWeapon chooseMeleeWeapon(){
        MeleeWeapon meleeWeapon = null;
        try{
            IOHandler.println(ANSI_BLUE + "choose melee weapon from the list:" + ANSI_RESET+
                    "\nCHAIN_SWORD \nCHAIN_AXE \nMANREAPER \nLIGHTING_CLAW \nPOWER_BLADE");
            meleeWeapon = MeleeWeapon.valueOf(bufferedReader.readLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            IOHandler.println(ANSI_RED + "entered non-existent value \nchoose from the options" + ANSI_RESET);
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "" + ANSI_RESET);
        }
        return meleeWeapon;
    }

    /**
     * create health value
     * throw IncorrectValueException if the values don't fit the constraints
     * @return Integer health
     */

    public Integer createHealth(){
        Integer health = 0;
        try{
            IOHandler.println(ANSI_BLUE + "enter health value: " + ANSI_RESET);
            health = parseInt(bufferedReader.readLine().trim());
            if(health <=0) throw new InvalidValueException();
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "" + ANSI_RESET);
            health = createHealth();
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "'health' must be over 0" + ANSI_RESET);
            health = createHealth();
        }
        return health;
    }

    /**
     * create loyal value
     * throw IncorrectValueException if the values don't fit the constraints
     * @return Boolean loyal
     */
    public Boolean createLoyal(){
        Boolean loyal = null;
        try{
            IOHandler.println(ANSI_BLUE + "enter loyal value [TRUE/FALSE]: " + ANSI_RESET);
            loyal = Boolean.parseBoolean(bufferedReader.readLine().trim().toUpperCase());
            if(loyal == Boolean.TRUE | Boolean.FALSE) throw new InvalidValueException();
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "'loyal' can't be null " + ANSI_RESET);
        } catch (IOException e) {
            IOHandler.println(ANSI_RED + "" + ANSI_RESET);
        }
        return loyal;
    }

    /**
     * create chapter with fields
     * throw IncorrectValueException if the values don't fit the constraints
     * @return ru.se.ifmo.lab5.data.Chapter
     */
    public Chapter createChapter(){
        String name;
        Integer marinesCount;
        String world = "";
        Chapter chapter;
        try{
            IOHandler.println(ANSI_BLUE + "enter chapter name: " + ANSI_RESET);
            name = bufferedReader.readLine().trim();
            IOHandler.println(ANSI_BLUE + "enter chapters' marines count: " + ANSI_RESET);
            marinesCount = parseInt(bufferedReader.readLine().trim());
            IOHandler.println(ANSI_BLUE + "enter chapters' world: " + ANSI_RESET);
            world = bufferedReader.readLine().trim();
            if(name.isBlank() | !(marinesCount > 0) | marinesCount > 1000) throw new InvalidValueException();
            chapter = new Chapter(name, marinesCount, world);

        } catch (NumberFormatException | IOException e) {
            IOHandler.println(ANSI_RED + "invalid data format: 'marines count' must be integer " + ANSI_RESET);
            chapter = createChapter();
        } catch (InvalidValueException e) {
            IOHandler.println(ANSI_RED + "'name' and 'world' can't be empty " +
                    "\n'marines count' must be over 0 and no more then 1000" + ANSI_RESET);
            chapter = createChapter();
        }

        return chapter;
    }

}
