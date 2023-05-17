package ru.se.ifmo.lab5.data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SpaceMarine implements Comparable<SpaceMarine>{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Boolean loyal; //Поле не может быть null
    private AstartesCategory category; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    /**
     * constructor
     *
     * @param id
     * @param name
     * @param coordinates
     * @param creationDate
     * @param health
     * @param loyal
     * @param category
     * @param meleeWeapon
     * @param chapter
     */

    public SpaceMarine(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer health, Boolean loyal,
                       AstartesCategory category, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.health = health;
        this.loyal = loyal;
        this.category = category;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;

    }
    public SpaceMarine(Integer id){
        this.id = id;
    }

    /**
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return Integer
     */
    public Integer getHealth() {
        return health;
    }

    /**
     * @return ZoneDateTime
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return Boolean
     */
    public Boolean getLoyal() {
        return loyal;
    }

    /**
     * @return AstartesCategory
     */
    public AstartesCategory getCategory() {
        return category;
    }

    /**
     * @return MeleeWeapon
     */
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    /**
     * @return Chapter
     */
    public Chapter getChapter() {
        return chapter;
    }
    /**
     * compares collection elements by id
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(SpaceMarine o) {
        return (int) this.id - o.getId();
    }
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        SpaceMarine spaceMarine = (SpaceMarine) o;
        return this.getId() == spaceMarine.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCoordinates(), getCreationDate(), getHealth(), getLoyal(), getCategory(), getMeleeWeapon(), getChapter());
    }

    @Override
    public String toString() {
        return ANSI_BLUE +"id: " + id  + ANSI_RESET +
                "\nname: " + name +
                "\ncoordinates: \nx = " + coordinates.getX() +
                "\ny = " + coordinates.getY() +
                "\ncreationDate: " + creationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                "\nhealth: " + health  +
                "\nloyal: " + loyal  +
                "\ncategory: " + category +
                "\nmeleeWeapon: " + meleeWeapon +
                "\nchapter: \nname: " + chapter.getName() +
                "\nmarinesCount: " + chapter.getMarinesCount() +
                "\nworld: " + chapter.getWorld() + "\n";
    }
    public String[] getAll() {
        return new String[]{String.valueOf(this.id), String.valueOf(this.name), String.valueOf(this.coordinates),
                String.valueOf(this.creationDate), String.valueOf(this.health), String.valueOf(this.loyal),
                String.valueOf(this.category), String.valueOf(this.meleeWeapon), String.valueOf(chapter.getName()),
                String.valueOf(chapter.getWorld()), String.valueOf(chapter.getMarinesCount())};
    }
    public String[] getValues() {
        return new String[]{
                id.toString(),
                name,
                coordinates.getX().toString(),
                Long.toString(coordinates.getY()),
                creationDate.toString(),
                health.toString(),
                loyal.toString(),
                category.toString(),
                meleeWeapon.toString(),
                chapter.getName(),
                Integer.toString(chapter.getMarinesCount()),
                chapter.getWorld()
        };
    }


}


