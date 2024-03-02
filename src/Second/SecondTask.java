package Second;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class SecondTask {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 9");
        System.out.println("Условие:");
        System.out.println("При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.");
        System.out.println("Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.");
        System.out.println("-------------------------\n");


        if (args.length != 1) {
            System.err.println("Usage: java MatrixRotator <filename>");
            System.exit(1);
        }

        String filename = args[0];

        File javaDirectory = new File("SwapFirstAndLastWords");
        javaDirectory.mkdir();
        File outputFile = new File(javaDirectory,"SwapFirstAndLastWords.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
             FileWriter writer = new FileWriter(outputFile);
             PrintWriter printWriter = new PrintWriter(writer)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("//")) { // Skip comments and import statements
                    String[] words = line.split("\\s+");
                    if (words.length >= 2) {
                        String firstWord = words[0];
                        words[0] = words[words.length - 1];
                        words[words.length - 1] = firstWord;
                        line = String.join(" ", words);
                    }
                }
                printWriter.println(line);
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения или записи файла: " + e.getMessage());
        }

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 10");
        System.out.println("Условие:");
        System.out.println("При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.");
        System.out.println("Ввести из текстового файла, связанного с входным потоком, последовательность строк. \nВыбрать и сохранить m последних слов в каждой из последних n строк");
        System.out.println("-------------------------\n");

        int n = 3;
        int m = 2;

        File javaDirectory1 = new File("SafeWords");
        javaDirectory1.mkdir();
        File outputFile1 = new File(javaDirectory1,"SafeWords.txt");

        Queue<String> lineQueue = new LinkedList<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(filename));
             FileWriter writer1 = new FileWriter(outputFile1);
             PrintWriter printWriter1 = new PrintWriter(writer1)) {

            String line2;
            while ((line2 = reader1.readLine()) != null) {
                lineQueue.add(line2);

                if (lineQueue.size() > n) {
                    lineQueue.remove();
                }
            }

            for (String line : lineQueue) {
                String[] words = line.split("\\s+");
                String line3 = "";
                for (int i = Math.max(0, words.length - m); i < words.length; i++) {
                    System.out.print(words[i] + " ");
                    line3 = line3 + words[i] + " ";
                }
                printWriter1.println(line3);
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения или записи файла " + e.getMessage());
        }
    }
}
