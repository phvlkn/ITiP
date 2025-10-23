public class Main {
    public static void main(String[] args) {
        HashTable<String, Student> table = new HashTable<>(7);

        table.put("A123", new Student("Иван", "Петров", 20, 4.3));
        table.put("B456", new Student("Анна", "Иванова", 19, 4.8));
        table.put("C789", new Student("Олег", "Сидоров", 21, 3.9));

        System.out.println("После добавления студентов:");
        table.printTable();

        System.out.println("\nПоиск студента с зачеткой B456:");
        System.out.println(table.get("B456"));

        table.remove("A123");
        System.out.println("\nПосле удаления студента A123:");
        table.printTable();

        System.out.println("\nКоличество студентов: " + table.size());
        System.out.println("Пуста ли таблица? " + table.isEmpty());
    }
}
