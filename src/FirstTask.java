import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FirstTask {
    static boolean flag = false;
    public static void main(String[] args) throws ParseException {
        System.out.println("-------------------------");
        System.out.println("ФИО разработчика: Шаговитов Михаил Игоревич");
        String dateFirst = "09.02.2024 14:29";
        System.out.println("Дата и время получения задания: " + dateFirst);

        Date dateSecond = new Date();
        SimpleDateFormat format1;
        format1 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Дата и время сдачи задания: " + format1.format(dateSecond));
        System.out.println("-------------------------\n");
        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k].");
        System.out.println("-------------------------\n");

        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Введите число k:");
        int k = input.nextInt();
        belongToDiapason(-10000, 0, k, 0);
        belongToDiapason(0, 5, k, 0);
        belongToDiapason(5, 10, k, 0);
        belongToDiapason(10, 10000, k, 0);
        if (!flag) {
            System.out.println("Введенное число не попало ни в один промежуток");
        }
        flag = false;

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 5], [0, 10], [5, 15], [10, 10k].");
        System.out.println("-------------------------\n");

        System.out.println("Введите число p:");
        int p = input.nextInt();
        belongToDiapason(-10000, 5, p, 0);
        belongToDiapason(0, 10, p, 1);
        belongToDiapason(5, 15, p, 1);
        belongToDiapason(10, 10000, p, 1);
        if (!flag) {
            System.out.println("Введенное число не попало ни в один промежуток");
        }
        flag = false;
    }
    public static void belongToDiapason(int startDiapason, int finishDiapason, int number, int prom) {
        int belong;
        switch (prom) {
            case 1:
                if (number >= startDiapason & number <= finishDiapason) {
                    belong = 2;
                } else belong = 0;
                break;
            case 0:
                if (number > startDiapason & number <= finishDiapason) {
                    belong = 1;
                } else belong = 0;
                break;
            default:
                belong = 0;
                break;
        }

        switch (belong) {
            case 2:
                System.out.println("Введенное число входит в промежуток " +
                        "[" + startDiapason + ", " + finishDiapason + "]");
                flag = true;
                break;
            case 1:
                System.out.println("Введенное число входит в промежуток " +
                        "(" + startDiapason + ", " + finishDiapason + "]");
                flag = true;
                break;
            case 0:
                break;
        }
    }
}