package Three;

import java.util.*;

public class ThreeTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 3, задача 9");
        System.out.println("Условие:");
        System.out.println("Напечатать слова русского текста в алфавитном порядке по первой букве. \nСлова, начинающиеся с новой буквы, печатать с красной строки.");
        System.out.println("-------------------------");

        System.out.println("Заданный текст:");
        System.out.println("Вася толкнул кота, а Кот поцарапал Васю");
        String text = "Вася толкнул кота, а Кот поцарапал Васю";
        System.out.println("Полученный результат:");
        printSortedWords(text);

        System.out.println("\n-------------------------");
        System.out.println("Вариант 3, задача 10");
        System.out.println("Условие:");
        System.out.println("Рассортировать слова русского текста по возрастанию доли гласных букв \n(отношение количества гласных к общему количеству букв в слове)");
        System.out.println("-------------------------");
        System.out.println("Заданный текст:");
        System.out.println("Вася толкнул кота, а Кот поцарапал Васю");
        String[] words = text.split("\\s+");
        Arrays.sort(words, Comparator.comparingInt(ThreeTask::countVowels));
        System.out.println("Полученный результат:");
        System.out.println(Arrays.toString(words));
    }

    private static int countVowels(String word) {
        int count = 0;
        String vowels = "аеёиоуыэюя";
        for (char c : word.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    private static void printSortedWords(String text) {
        List<String> words = splitIntoWords(text);
        Collections.sort(words, new WordComparator());
        printWithFormatting(words);
    }

    private static List<String> splitIntoWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                currentWord.append(Character.toUpperCase(c));
            } else if (currentWord.length() > 0) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        return words;
    }

    private static void printWithFormatting(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (i > 0 && !word.toUpperCase().startsWith(words.get(i - 1).toUpperCase().substring(0, 1))) {
                System.out.println();
            }
            System.out.print(word + " ");
        }
    }

    private static class WordComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.toUpperCase().charAt(0) - o2.toUpperCase().charAt(0);
        }
    }
}
