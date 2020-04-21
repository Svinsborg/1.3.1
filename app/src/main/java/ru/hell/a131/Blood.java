package ru.hell.a131;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Blood {


    private int prUp;
    private int prDw;
    private int pulse;
    private boolean tah;
    private Date date;
    private Time time;


    public Blood(int prUp, int prDw, int pulse, boolean tah, Date date, Time time) {
        this.prUp = prUp;
        this.prDw = prDw;
        this.pulse = pulse;
        this.tah = tah;
        this.date = date;
        this.time = time;
    }

    public int getPrUp() {
        return prUp;
    }

    public void setPrUp(int prUp) {
        this.prUp = prUp;
    }

    public int getPrDw() {
        return prDw;
    }

    public void setPrDw(int prDw) {
        this.prDw = prDw;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public boolean isTah() {
        return tah;
    }

    public void setTah(boolean tah) {
        this.tah = tah;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blood blood = (Blood) o;
        return prUp == blood.prUp &&
                prDw == blood.prDw &&
                pulse == blood.pulse &&
                tah == blood.tah &&
                Objects.equals(date, blood.date) &&
                Objects.equals(time, blood.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prUp, prDw, pulse, tah, date, time);
    }
}
