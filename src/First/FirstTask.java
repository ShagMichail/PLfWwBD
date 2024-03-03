package First;
import java.util.Scanner;
public class FirstTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("Из текста удалить все слова заданной длины, начинающиеся на согласную букву.");
        System.out.println("-------------------------");

        System.out.println("Вывод изначального текста:");
        System.out.println("This is a test sentence. We are removing words of a certain length that start with a consonant.\n");
        String input = "This is a test sentence. We are removing words of a certain length that start with a consonant.";
        int wordLength = 4;
        String output = removeWords(input, wordLength);
        System.out.println("Вывод результата удаления слов:");
        System.out.println(output);

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Удалить из текста его часть, заключенную между двумя символами, \nкоторые вводятся (например, между скобками ‘(’ и ‘)’ или между звездочками ‘*’ и т.п.).");
        System.out.println("-------------------------");

        System.out.println("Вывод изначального текста:");
        System.out.println("This is a test *to remove* (enclosed) part.\n");
        String input2 = "This is a test *to remove* (enclosed) $part$.";
        System.out.println("Введите символы {},[],() и тд:");
        Scanner inputS;
        inputS = new Scanner(System.in);
        String k = inputS.nextLine();
        System.out.println("Вывод результата удаления слов:");
        System.out.println(removeEnclosedPart(input2, k.charAt(0), k.charAt(1)));
    }

    public static String removeEnclosedPart(String input, char open, char close) {
        int openIndex = -1;
        int closeIndex = -1;

        while (true) {
            openIndex = input.indexOf(open, openIndex + 1);
            closeIndex = openIndex + 1;
            closeIndex = input.indexOf(close, closeIndex) + 1;

            if (openIndex == -1 || closeIndex == -1) {
                break;
            }

            if (openIndex < closeIndex) {
                String prefix = input.substring(0, openIndex);
                String suffix = input.substring(closeIndex + 1);
                input = prefix + suffix;
            }
        }

        return input;
    }


    public static String removeWords(String input, int length) {
        StringBuilder sb = new StringBuilder();
        String[] words = input.split(" ");
        for (String word : words) {
            if (!(word.length() == length && isConsonant(word.charAt(0)))) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }
}
