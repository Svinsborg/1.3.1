package ru.hell.a131;

import java.util.Objects;

public class Statistic {

    private double weight;
    private int steps;

    public Statistic(double weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return Double.compare(statistic.weight, weight) == 0 &&
                steps == statistic.steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, steps);
    }
}
