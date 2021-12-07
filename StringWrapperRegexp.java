package by.itacademy.practice.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWrapperRegexp {
    String text = new String("There is no one who loves pain itself,\n" +
            " who seeks after it and wants to have it, simply because it is pain");
    String textWithComments = new String("// comments_1\n" +
            "/*comments_2 */" +
            "\n" +
            "/**\n" +
            "*comments_3\n" +
            "*/\n" +
            "No more comments\n");
    String regExpPattern = "(\\s+)";
    String replacement = "-";

    public static void main(String[] args) {

        StringWrapperRegexp stringWrapperRegexp = new StringWrapperRegexp();
        stringWrapperRegexp.run();
    }

    private void run() {
        System.out.println("Инвертировать строку\n:");
        reverse(text);
        System.out.println("Количество всех гласных бук в заданном тексте\n:");
        vowelsNumber(text);
        System.out.println("Сколько раз повторяется в тексте каждое слово, которое \n" +
                "встречается в нем\n:");
        countOfWordRepeat(text);
        System.out.println("Из кода Java удалить все комментарии (//, /*, /**):");
        System.out.println("Исходный текст:\n" + textWithComments);
        System.out.println("Текст без комментариев:\n" + deleteComment(textWithComments));
        System.out.println("Вывести в заданном тексте все слова, расположив их в алфавитном порядке:");
        System.out.println(Arrays.toString(wordsInAlphabetOrder(text)));
        System.out.println("Ввести из консоли e-mail, проверить, соответствует ли введенное значение\n" +
                "правилам, определяющим e-mail:");
        enterEmail();
        System.out.println("Ввести из консоли IP-адрес. Проверить на соответствие шаблону с помощью regexp:");
        ipAddress();
        System.out.println("Заменить в тексте подстроку, соответствующую заданному регулярному выражению:");
        System.out.println(replaceSubString(text, regExpPattern, replacement));

    }


    private static void reverse(String str) {
        char[] reverseArray = str.toCharArray();
        for (int i = reverseArray.length - 1; i > 0; i--) {
            System.out.print(reverseArray[i]);
        }
        System.out.println();
    }

    private static void vowelsNumber(String str) {
        int count = 0;
        char[] strToChar = str.toCharArray();
        char[] vowelsArray = {'a', 'A', 'e', 'E', 'o', 'O', 'u', 'U', 'i', 'I'};
        for (int i = 0; i < vowelsArray.length; i++) {
            for (int j = 0; j < strToChar.length; j++) {
                if (vowelsArray[i] == strToChar[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void countOfWordRepeat(String str) {
        String[] wordsArray = str.toLowerCase().replaceAll("[-.?!)(,:]", " ").split(" ");
        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                Integer count = counterMap.get(word);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(word, ++count);
            }
        }
        for (String word : counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }
    }

    private String deleteComment(String str) {
        String regex = "(\\/\\/.[\\S\\s]+?\\n)|(\\/\\*.*[\\S\\s]*\\*\\/\\n)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher((str));
        String result = m.replaceAll("");
        return result;
    }

    private String[] wordsInAlphabetOrder(String str) {
        String[] wordSortArray = str.toLowerCase().replaceAll("[-.?!)(,:]", " ").split(" ");
        Arrays.sort(wordSortArray);
        return wordSortArray;
    }

    private static void enterEmail() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите e-mail: ");
        String email = in.next();
        String regex = "(\\w+)@(\\w+\\.)([a-z]{2,4})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.find()) {
            System.out.println("Your e-mail address is correct");
        } else {
            System.out.println("Your e-mail address is not correct");
        }
    }

    private static void ipAddress() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите IP-адрес: ");
        String ip = in.next();
        String regexIPs = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern p = Pattern.compile(regexIPs);
        Matcher m = p.matcher(ip);
        if (m.matches()) {
            System.out.println("IP-адрес корректный");
            in.close();
        } else {
            System.out.println("IP-адрес не корректный");
        }
    }

    private String replaceSubString(String text, String regExpPattern, String replacement) {
        return text.replaceAll(regExpPattern, replacement);
    }
}
