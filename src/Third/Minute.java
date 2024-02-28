package Third;

import java.util.Objects;

public class Minute {
    private final int minute;

    public Minute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Minute)) return false;
        Minute minute1 = (Minute) o;
        return minute == minute1.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minute);
    }
    @Override
    public String toString() {
        return "Minute{" +
                "minute=" + minute +
                '}';
    }
}
