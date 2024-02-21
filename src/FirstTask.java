import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class FirstTask {
    public static void main(String[] args) {

        System.out.println("Вариант 1, задача 1");
        System.out.println("Условие:");
        System.out.println("Создать класс Hello, который будет приветствовать любого пользователя, используя командную строку.");

        Scanner input;
        input = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        new Hello(input.next());

        System.out.println("Вариант 1, задача 2");
        System.out.println("Условие:");
        System.out.println("Создать приложение, которое отображает в окне консоли аргументы командной строки метода main() в обратном порядке.");

        System.out.println("Аргументы командной строки:");
        for (int i = args.length-1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}

class Hello {
    public Hello(String userName) {
        System.out.println("Hello " + userName);
    }
}