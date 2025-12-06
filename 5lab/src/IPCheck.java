import java.util.regex.*;
import java.util.Scanner;

public class IPCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите IP:");
        String ip = sc.nextLine();

        String regex =
            "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}"
          + "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";

        if (ip.matches(regex)) System.out.println("IP корректный");
        else System.out.println("IP НЕ корректный");
    }
}