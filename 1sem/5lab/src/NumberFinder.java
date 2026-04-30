import java.util.regex.*;
import java.util.Scanner;

public class NumberFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();

        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные числа:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}