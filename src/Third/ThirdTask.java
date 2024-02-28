package Third;

import java.util.Arrays;

public class ThirdTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 3, задача 10");
        System.out.println("Условие:");
        System.out.println("Создать приложение, удовлетворяющее требованиям, приведенным в задании.\n Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().\n");
        System.out.println("Создать объект класса Год, используя классы Месяц, День.\n Методы:\n задать дату,\n вывести на консоль день недели по заданной дате,\n рассчитать количество дней, месяцев в заданном временном промежутке.\n");
        System.out.println("-------------------------\n");

        String[] nameDays = new String[] { "Monday", "Tuesday", "Wednesday","Thursday","Friday", "Saturday","Sunday" };
        String[] nameMonth = new String[] { "January", "February", "March","April","May", "June","July","August", "September","October","November","December" };
        int j = 0;
        Month[] months = new Month[12];
        for (int k = 0; k < Arrays.stream(nameMonth).count(); k++) {
            int size = 31;
            if (k == 0 || k == 2 || k == 4 || k == 6 || k == 7 || k == 9 || k == 11 ) {
                size = 31;
            } else if (k == 1) {
                size = 29;
            } else {
                size = 30;
            }
            Day[] daysOfMonth = new Day[size];
            for (int i = 0; i < Arrays.stream(daysOfMonth).count(); i++){
                if (j == 7) {
                    j = 0;
                }
                daysOfMonth[i] = new Day(nameDays[j],i + 1);
                j++;
            };
            Month month = new Month(nameMonth[k], daysOfMonth);
            months[k] = month;
        }

        Year year = new Year(2024, months,"20/5/2024");
        System.out.println(year);
        System.out.println("Вывод дня недели при инициализации года:");
        year.getDayOfWeek();
        System.out.println("Вывод дня недели при установке даты:");
        year.setData("22/5/2024");

        year.getDayOfWeek();
        System.out.println("Вывод дня недели заданной даты:");
        year.getDayOfWeek("25/5/2024");
        System.out.println("Вывод количества дней и месецев заданного промежутка:");
        year.getProm("22/5/2024","3/6/2024");


        System.out.println("-------------------------");
        System.out.println("Вариант 3, задача 11");
        System.out.println("Условие:");
        System.out.println("Создать приложение, удовлетворяющее требованиям, приведенным в задании.\n Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().\n");
        System.out.println("Создать объект класса Сутки, используя классы Час, Минута.\n Методы:\n вывести на консоль текущее время,\n рассчитать время суток (утро, день, вечер, ночь).\n");
        System.out.println("-------------------------\n");

        Hour hour = new Hour(14);
        Minute minute = new Minute(30);

        DaySecond daySecond = new DaySecond(hour, minute);
        System.out.println("Вывод текущего заданного времени:");
        daySecond.printCurrentTime();
        System.out.println("Определение времени суток относительно заданного времени:");
        System.out.println(daySecond.getTimeOfDay());
    }
}
