package First;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 5");
        System.out.println("Условие:");
        System.out.println("Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.");
        System.out.println("Задана коллекция строк. Вернуть список из коллекции без повторов.");
        System.out.println("-------------------------");

        List<String> strings = Arrays.asList("hello", "world", "hello", "Java", "world");
        System.out.println("Заданная коллекция строк:");
        System.out.println(strings);
        List<String> uniqueStrings = strings.stream()  // создание потока из списка строк
                .distinct()                            // удаляет дублирующиеся элементы
                .collect(Collectors.toList());         // собираем элементы потока и преобразовываем их к нужному типу
        System.out.println("Строка после удаления дубликатов:");
        System.out.println(uniqueStrings);

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 6");
        System.out.println("Условие:");
        System.out.println("Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.");
        System.out.println("Задана коллекция строк. Объединить все элементы в одну строку через разделитель “:”");
        System.out.println("-------------------------");

        System.out.println("Заданная коллекция строк:");
        System.out.println(strings);
        String joinedString = strings.stream()
                .collect(Collectors.joining(":"));
        System.out.println("Строка после объединения по символу ':':");
        System.out.println(joinedString);

    }
}
