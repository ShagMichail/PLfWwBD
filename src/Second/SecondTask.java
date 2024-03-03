package Second;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 9");
        System.out.println("Условие:");
        System.out.println("В стихотворении найти одинаковые буквы, которые встречаются во всех словах.");
        System.out.println("-------------------------");
        System.out.println("Заданный текст:");
        System.out.println("Java iavs av progvramming languavge. Javva iavs avlso av covffaee.");
        String inputString = "Java iavs av progvramming languavge. Javva iavs avlso av covffaee.";

        List<String> words = Arrays.asList(inputString.split("\\s+"));

        Set<Character> commonLetters = new HashSet<>();
        for (int i = 0; i < words.get(0).length(); i++) {
            char letter = words.get(0).charAt(i);
            boolean isCommon = false;
            int r = 1;
            for (int j = 1; j < words.size(); j++) {
                for (int p = 0; p < words.get(j).length(); p++) {
                    if (words.get(j).charAt(p) == letter) {
                        isCommon = true;
                    }
                }
                if (isCommon) {
                    r++;
                }
            }
            if (r == words.size()) {
                commonLetters.add(letter);
            }
        }

        System.out.println("Буквы, которые встречаются в каждом слове: " + commonLetters);


        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 10");
        System.out.println("Условие:");
        System.out.println("В тексте найти первую подстроку максимальной длины, не содержащую букв.");
        System.out.println("-------------------------");
        System.out.println("Заданный текст:");
        System.out.println("This is a test 6378 Java program. Java is a popular programming 48584 language. We will find 7&84()347 a substring without java.");
        String text = "This is a test 6378 Java program. Java is a popular programming 48584 language. We will find 7&84()347 a substring without java.";
        System.out.println("Найденная подстрока:");
        System.out.println(findMaxSubstringNoJava(text));
    }

    public static String findMaxSubstringNoJava(String text) {
        String maxSubstring = "";
        String currentSubstring = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                currentSubstring = "";
            } else {
                if (!isSubstringContainsJavaLetters(currentSubstring, text.charAt(i))) {
                    currentSubstring += text.charAt(i);
                } else {
                    currentSubstring = "";
                }
            }

            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring;
            }
        }

        return maxSubstring;
    }

    public static boolean isSubstringContainsJavaLetters(String substring, char c) {
        String javaLetters = "[qQwWeErRtTyYuUiIoOpPSsdDfFgGhHkKlLzZxXcCbBnNmMjJaAvV]";
        Pattern pattern = Pattern.compile(javaLetters);
        Matcher matcher = pattern.matcher(substring + c);

        return matcher.find();
    }
}
