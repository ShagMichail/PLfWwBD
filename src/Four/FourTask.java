package Four;
import java.util.*;
public class FourTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 4, задача 9");
        System.out.println("Условие:");
        System.out.println("Преобразовать каждое слово в тексте, удалив из него все последующие \n(предыдущие) вхождения первой (последней) буквы этого слова");
        System.out.println("-------------------------");
        System.out.println("Заданный текст:");
        System.out.println("Thits isii a Javja progppppram that prints Helhhhlo World!");
        String text = "Thits isii a Javja progppppram that prints Helhhhlo World!";
        String transformedText = transformText(text);
        System.out.println("Преобразованный текст:");
        System.out.println(transformedText);

        System.out.println("-------------------------");
        System.out.println("Вариант 4, задача 10");
        System.out.println("Условие:");
        System.out.println("Исключить из текста подстроку максимальной длины, \nначинающуюся и заканчивающуюся одним и тем же символом");
        System.out.println("-------------------------");
        System.out.println("Заданный текст:");
        System.out.println("Hah tdst rfjklghr dhfhd");
        String text2 = "Hah tdst rfjklghr dhfhd";
        String transformedText2 = removeText(text2);
        System.out.println("Преобразованный текст:");
        System.out.println(transformedText2);
    }

    public static String removeText(String text) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbremow = new StringBuilder();
        String[] words = text.split("\\s");
        int removIndex = 0;
        int promIndex = 0;
        int promIndex2 = 0;
        for (String word : words) {
            StringBuilder sbprom = new StringBuilder();
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            if (Character.toUpperCase(firstChar) == lastChar || Character.toLowerCase(firstChar) == lastChar) {
                for (int i = 0; i < word.length(); i++) {
                    sbprom.append(word.charAt(i));
                }
            }
            if (sbremow.length() < sbprom.length()) {
                sbremow = sbprom;
                removIndex = promIndex;
            }
            promIndex++;
        }
        for (String word : words) {
            if (promIndex2 != removIndex) {
                for (int i = 0; i < word.length(); i++) {
                    sb.append(word.charAt(i));
                }
                sb.append(" ");
            }
            promIndex2++;
        }
        return sb.toString().trim();
    }

    public static String transformText(String text) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split("\\s");
        for (String word : words) {
            char firstChar = word.charAt(0);
            sb.append(firstChar);
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) != Character.toUpperCase(firstChar) &&  word.charAt(i) != Character.toLowerCase(firstChar)) {
                    sb.append(word.charAt(i));
                }
            }
            sb.append(" ");

        }
        return sb.toString().trim();
    }
}
