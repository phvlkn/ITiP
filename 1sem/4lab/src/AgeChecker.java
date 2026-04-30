import java.util.Scanner;

public class AgeChecker {

    public static void checkAge(int age) throws CustomAgeException { //заявляем что может выбрасывать customageexeption
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        }
        System.out.println("Возраст корректный: " + age);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст: ");

        try {
            int age = scanner.nextInt();
            checkAge(age);
        }
        catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Ошибка ввода. Введите число.");
        }
        finally {
            System.out.println("Проверка завершена.");
        }
    }
}
