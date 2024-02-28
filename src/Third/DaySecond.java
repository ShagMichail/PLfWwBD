package Third;

import java.util.Objects;

public class DaySecond {
    private final Hour hour;
    private final Minute minute;

    public DaySecond(Hour hour, Minute minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Hour getHour() {
        return hour;
    }

    public Minute getMinute() {
        return minute;
    }

    public void printCurrentTime() {
        System.out.println(hour.getHour() + ":" + minute.getMinute());
    }

    public String getTimeOfDay() {
        int hourOfDay = hour.getHour();
        if (hourOfDay >= 6 && hourOfDay < 12) {
            return "Утро";
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            return "День";
        } else if (hourOfDay >= 18 && hourOfDay < 22) {
            return "Вечер";
        } else {
            return "Ночь";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySecond)) return false;
        DaySecond daySecond = (DaySecond) o;
        return hour.equals(daySecond.hour) && minute.equals(daySecond.minute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    @Override
    public String toString() {
        return "DaySecond{" +
                "hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
