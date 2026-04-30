import java.util.regex.*;
import java.util.Scanner;

public class CapitalAfterLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();

        Pattern pattern = Pattern.compile("[a-z]([A-Z])");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Заглавные буквы после строчных:");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}