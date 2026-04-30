import java.util.regex.*;
import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пароль:");
        String pass = sc.nextLine();

        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        boolean ok = pass.matches(regex);

        if (ok) System.out.println("Пароль корректный");
        else System.out.println("Пароль НЕ соответствует требованиям");
    }
}