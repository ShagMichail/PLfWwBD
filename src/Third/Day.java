package Third;

import java.util.Objects;

public class Day {
    private String name;
    private int date;

    public Day(String name, int date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return date == day.date && Objects.equals(name, day.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }

    @Override
    public String toString() {
        return "Day{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}