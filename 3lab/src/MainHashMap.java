import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Создаем хэш-карту: ключ — номер зачетки, значение — объект Student
        Map<String, Student> students = new HashMap<>();

        // Вставка студентов
        students.put("A123", new Student("Иван", "Петров", 20, 4.3));
        students.put("B456", new Student("Анна", "Иванова", 19, 4.8));
        students.put("C789", new Student("Олег", "Сидоров", 21, 3.9));

        // Выводим всех студентов
        System.out.println("Все студенты:");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println("Зачетка: " + entry.getKey() + " — " + entry.getValue());
        }

        // Поиск студента по номеру зачетки
        String searchKey = "B456";
        System.out.println("\nПоиск студента с зачеткой " + searchKey + ":");
        Student found = students.get(searchKey);
        if (found != null)
            System.out.println(found);
        else
            System.out.println("Студент не найден.");

        // Удаление студента
        String removeKey = "A123";
        System.out.println("\nУдаляем студента с зачеткой " + removeKey);
        students.remove(removeKey);

        // Выводим оставшихся студентов
        System.out.println("\nПосле удаления:");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println("Зачетка: " + entry.getKey() + " — " + entry.getValue());
        }

        // Проверяем размер и пустоту
        System.out.println("\nКоличество студентов: " + students.size());
        System.out.println("Пуста ли таблица? " + students.isEmpty());
    }
}