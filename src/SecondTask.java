import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {

        boolean flag = false;

        System.out.println("Вариант 2, задача 4");
        System.out.println("Условие:");
        System.out.println("Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:\n " +
                "Числа, которые делятся на 5 и на 7.");
        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int[] array = new int[size]; // Создаём массив int размером в size
        System.out.println("Введите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print ("Вывод элементов, которые делятся на 5 и 7:");
        for (int i = 0; i < size; i++) {
            if (array[i] % 5 == 0 & array[i] % 7 == 0) {
                flag = true;
                System.out.print (" " + array[i]); // Выводим на экран, полученный массив
            }
        }
        if (!flag) {
            System.out.print (" Нет таких элементов"); // Выводим на экран, полученный массив
        }
        System.out.println();

        System.out.println("Вариант 2, задача 5");
        System.out.println("Условие:");
        System.out.println("Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:\n " +
                "Элементы, расположенные методом пузырька по убыванию модулей.");

        Scanner inputSecond;
        inputSecond = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int sizeSecond = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int[] arraySecond = new int[sizeSecond]; // Создаём массив int размером в size
        System.out.println("Введите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < sizeSecond; i++) {
            arraySecond[i] = inputSecond.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print ("Вывод элементов, отсортированный методом пузырька по убыванию модулей:");
        for (int i = 0; i < sizeSecond; i++) {
            for (int j = 0; j < sizeSecond - 1; j++) {
                if (Math.abs(arraySecond[j]) < Math.abs(arraySecond[j+1])) {
                    int firstElement = arraySecond[j];
                   // int j = arraySecond[j];
                    arraySecond[j] = arraySecond[j+1];
                    arraySecond[j+1] = firstElement;
                    //System.out.print(" " + array[i]); // Выводим на экран, полученный массив
                }
            }
        }

        for (int i = 0; i < sizeSecond; i++) {
            System.out.print(" " + arraySecond[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

    }
}

