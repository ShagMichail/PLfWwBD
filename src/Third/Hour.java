package Third;

import java.util.Objects;

public class Hour {
    private final int hour;

    public Hour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hour)) return false;
        Hour hour1 = (Hour) o;
        return hour == hour1.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour);
    }

    @Override
    public String toString() {
        return "Hour{" +
                "hour=" + hour +
                '}';
    }
}
