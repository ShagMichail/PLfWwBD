package Third;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
public class Year {
    private int year;
    private String data;
    private Month[] months;

    public Year(int year, Month[] months, String data) {
        this.year = year;
        this.months = months;
        this.data =  data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Month getMonth(int month) {
        return months[month - 1];
    }

    public void getDayOfWeek(String data) {
        String input = data;
        String[] lines = input.split("/");
        if (this.year != Integer.parseInt(lines[2])) {
            throw new IllegalArgumentException("Нет такого года!");
        } else if (Integer.parseInt(lines[1]) > 12 || Integer.parseInt(lines[1]) < 1 ) {
            throw new IllegalArgumentException("Нет такого месяца!");
        } else if (Integer.parseInt(lines[0]) < 1 || Integer.parseInt(lines[0]) > (int) getMonth(Integer.parseInt(lines[1])).getDays()) {
            throw new IllegalArgumentException("Нет такого дня в месяце!");
        } else {
            Day isk = getMonth(Integer.parseInt(lines[1])).getDays(Integer.parseInt(lines[0]));
            System.out.println(isk.getName());
        }
    }

    public void getDayOfWeek() {
        String input = data;
        String[] lines = input.split("/");
        if (this.year != Integer.parseInt(lines[2])) {
            throw new IllegalArgumentException("Нет такого года!");
        } else if (Integer.parseInt(lines[1]) > 12 || Integer.parseInt(lines[1]) < 1 ) {
            throw new IllegalArgumentException("Нет такого месяца!");
        } else if (Integer.parseInt(lines[0]) < 1 || Integer.parseInt(lines[0]) > (int) getMonth(Integer.parseInt(lines[1])).getDays()) {
            throw new IllegalArgumentException("Нет такого дня в месяце!");
        } else {
            Day isk = getMonth(Integer.parseInt(lines[1])).getDays(Integer.parseInt(lines[0]));
            System.out.println(isk.getName());
        }
    }

    public void getProm(String dataNach, String dataKon) {
        String inputF = dataNach;
        String[] linesF = inputF.split("/");
        String inputS = dataKon;
        String[] linesS = inputS.split("/");
        if (this.year != Integer.parseInt(linesF[2]) || this.year != Integer.parseInt(linesS[2])) {
            throw new IllegalArgumentException("Нет такого года!");
        } else if (Integer.parseInt(linesF[1]) > 12 || Integer.parseInt(linesF[1]) < 1 || Integer.parseInt(linesS[1]) > 12 || Integer.parseInt(linesS[1]) < 1 ) {
            throw new IllegalArgumentException("Нет такого месяца!");
        } else if (Integer.parseInt(linesF[0]) < 1 || Integer.parseInt(linesF[0]) > (int) getMonth(Integer.parseInt(linesF[1])).getDays() || Integer.parseInt(linesS[0]) < 1 || Integer.parseInt(linesS[0]) > (int) getMonth(Integer.parseInt(linesS[1])).getDays()) {
            throw new IllegalArgumentException("Нет такого дня в месяце!");
        } else {
            String date1 = dataNach;
            String date2 = dataKon;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

            LocalDate date1LocalDate = LocalDate.parse(date1, formatter);
            LocalDate date2LocalDate = LocalDate.parse(date2, formatter);

            int days = 0;
            int months = 0;

            if (date1LocalDate.isBefore(date2LocalDate)) {
                months = Integer.parseInt(linesS[1]) - Integer.parseInt(linesF[1]) + 1;
                LocalDate date = date1LocalDate;
                while (!date.isAfter(date2LocalDate)) {
                    days++;
                    date = date.plusDays(1);
                }
            } else {
                months = Integer.parseInt(linesF[1]) - Integer.parseInt(linesS[1]) + 1;
                LocalDate date = date2LocalDate;
                while (!date.isAfter(date1LocalDate)) {
                    days++;
                    date = date.plusDays(1);
                }
            }

            System.out.println("Количество дней в промежутке с " + date1 + " до " + date2 + ": " + days);
            System.out.println("Количество месецев в промежутке с " + date1 + " до " + date2 + ": " + months);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year1 = (Year) o;
        return year == year1.year && Arrays.equals(months, year1.months);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + Arrays.hashCode(months);
        return result;
    }


    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                ",\n   months=" + Arrays.toString(months) +
                '}';
    }
}
