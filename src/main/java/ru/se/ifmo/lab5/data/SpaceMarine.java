package ru.se.ifmo.lab5.data;

import ru.se.ifmo.lab5.utils.Creator;
import ru.se.ifmo.lab5.utils.Reader;

import java.time.ZonedDateTime;
import java.util.Objects;

public class SpaceMarine implements Comparable<SpaceMarine>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Boolean loyal; //Поле не может быть null
    private AstartesCategory category; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null
    public Creator creator;
    public Reader reader;

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
        this.creationDate = creationDate;
        this.health = health;
        this.loyal = loyal;
        this.meleeWeapon = meleeWeapon;
        this.category = category;
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
        return (int) id - o.getId();
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
        return "id: " + id + "\n" +
                "name: " + name + "\n" +
                "coordinates: \nx = " + coordinates.getX() + "\n" +
                "y = " + coordinates.getY() + "\n" +
                "creationDate: " + creationDate + "\n" +
                "health: " + health  + "\n" +
                "loyal: " + loyal  + "\n" +
                "category: " + category + "\n" +
                "meleeWeapon: " + meleeWeapon + "\n"+
                "chapter: \nname: " + chapter.getName() + "\n" +
                "marinesCount: " + chapter.getMarinesCount() + "\n" +
                "world: " + chapter.getWorld();
    }

}


