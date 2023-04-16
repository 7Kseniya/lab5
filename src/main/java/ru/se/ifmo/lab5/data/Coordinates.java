package ru.se.ifmo.lab5.data;

import java.util.Objects;

public class Coordinates {
    private float x;
    //Максимальное значение поля: 345, Поле не может быть null
    private long y;
    //Значение поля должно быть больше -975


    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return getX() == coordinates.getX() && getY() == coordinates.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Coordinates:" + "x=" + x + ", y=" + y;
    }
}