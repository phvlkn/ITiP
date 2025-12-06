import java.util.regex.*;
import java.util.Scanner;

public class WordsByLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();

        System.out.println("Введите начальную букву:");
        char letter = sc.nextLine().charAt(0);

        String regex = "\\b" + letter + "[A-Za-zА-Яа-яЁё]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с '" + letter + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}