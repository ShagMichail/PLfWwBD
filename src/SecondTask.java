import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SecondTask {
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
        System.out.println("Вариант 2, задача 9");
        System.out.println("Условие:");
        System.out.println("Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n\n" +
                "до n с помощью датчика случайных чисел. \n" + "Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.");
        System.out.println("-------------------------\n");

        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int[][] array = new int[n][n];

        Random r = new Random(System.currentTimeMillis());
        int summ = 0;
        System.out.print ("Вывод элементов, полученной матрицы:\n");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = r.nextInt(n + n + 1) - n;
                summ += array[i][j];
                System.out.print(" " + array[i][j]);
            }
            System.out.print("\n");
        }
        int sred = summ / n*n;
        System.out.print ("Среднее арифметическое матрицы: " + sred + "\n");

        System.out.print ("Вывод элементов, после преобразования:");
        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = array[i][j] - sred;
                System.out.print(" " + array[i][j]); // Выводим на экран, полученный массив
            }
            System.out.print("\n");
        }


        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 10");
        System.out.println("Условие:");
        System.out.println("Ввести с консоли n – размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n\n" +
                "до n с помощью датчика случайных чисел. \n" + "Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие");
        System.out.println("-------------------------\n");

        System.out.println("Введите размер массива: ");
        n = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int[][] arraySecond = new int[n][n];
        int max = -n;
        System.out.print ("Вывод элементов, полученной матрицы:\n");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arraySecond[i][j] = r.nextInt(n + n + 1) - n;
                if (max < arraySecond[i][j]) {
                    max = arraySecond[i][j];
                }
                System.out.print(" " + arraySecond[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print ("Максимальный элемент в матрице:");
        System.out.print(max + "\n");

        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();

        // Поиск колонок и столбцов, которые надо удалить
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(max == arraySecond[i][j]) {
                    if(rows.indexOf(i) == -1)
                        rows.add(i);
                    if(column.indexOf(j) == -1)
                        column.add(j);
                }
            }
        }

        int[][] newArr = new int[n - rows.size()][n - column.size()];
        System.out.println("Размер новой матрицы: " + (n - rows.size()) + "x" + (n - column.size()));

        System.out.print ("Полученная матрица, после удаления строк и столбцов:\n");
        int newArrI = 0;
        int newArrJ = 0;
        // СЗаполняем новый массив без столбцов и строк с мах числом
        for (int i = 0; i < n; i++) {
            if(rows.indexOf(i) == -1) {
                newArrJ = 0;
                for (int j = 0; j < n; j++) {
                    if(column.indexOf(j) == -1) {
                        newArr[newArrI][newArrJ]
                                = arraySecond[i][j];
                        newArrJ++;
                    }
                }
                newArrI++;
            }
        }

        // Печать результатата
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.print(" " + newArr[i][j]);
            }
            System.out.print("\n");
        }
    }
}
