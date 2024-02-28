package Third;

import java.util.Arrays;
import java.util.Objects;

public class Month {
    private String name;
    private Day[] days;

    public Month(String name, Day[] days) {
        this.name = name;
        this.days = days;
    }

    public long getDays() {
        return Arrays.stream(days).count();
    }

    public Day getDays(int day) {
        int dayP = day-1;
        return days[dayP];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Arrays.equals(days, month.days) && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(days);
        return result;
    }

    @Override
    public String toString() {
        return "Month{" +
                "\nname='" + name + '\'' +
                ",\n days=" + Arrays.toString(days) +
                '}';
    }
}
