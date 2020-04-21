package ru.hell.a131;

import java.util.Objects;

public class Individual {
    private String name;
    private String brDay;

    public Individual(String name, String brDay) {
        this.name = name;
        this.brDay = brDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrDay() {
        return brDay;
    }

    public void setBrDay(String brDay) {
        this.brDay = brDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(brDay, that.brDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brDay);
    }
}
