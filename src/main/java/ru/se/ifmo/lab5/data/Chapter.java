package ru.se.ifmo.lab5.data;

import ru.se.ifmo.lab5.utils.IOHandler;

import java.util.Objects;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле не может быть null

    /**
     * @param name
     * @param marinesCount
     * @param world
     */
    public Chapter(String name, Integer marinesCount, String world) {
        if(!(name.isBlank())){
            this.name = name;
        }else{
            IOHandler.println("incorrect value of 'name'");
        }
        if(!(marinesCount == null)){
            this.marinesCount = marinesCount;
        }else{
            IOHandler.println("param 'marine count is null");
        }
        if(!(world == null)){
            this.world = world;
        }else{
            IOHandler.println("incorrect value of param 'world");
        }
    }

    /**
     * get name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * get marine count
     * @return Integer
     */

    public Integer getMarinesCount() {
        return marinesCount;
    }

    /**
     * get world
     * @return String
     */
    public String getWorld() {
        return world;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return getName() == chapter.getName() &&
                getMarinesCount() == chapter.getMarinesCount()
                && getWorld() == chapter.getWorld();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMarinesCount(), getWorld());
    }
}