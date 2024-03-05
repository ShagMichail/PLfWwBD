package Second;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondTask {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 5");
        System.out.println("Условие:");
        System.out.println("Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.");
        System.out.println("Задана коллекция строк. Преобразовать в MAP, сгруппировав по первому символу строки.");
        System.out.println("-------------------------");

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "avocado", "coconut", "grape");
        System.out.println("Заданная коллекция строк:");
        System.out.println(strings);
        Map<String, List<String>> map = strings.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
        System.out.println("Строка после группировки:");
        System.out.println(map);

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 6");
        System.out.println("Условие:");
        System.out.println("Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.");
        System.out.println("Задана коллекция чисел. Получить сумму четных чисел.");
        System.out.println("-------------------------");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Заданная коллекция чисел:");
        System.out.println(numbers);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Полученная сумма:");
        System.out.println(sum);
    }
}
