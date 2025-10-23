public class Student {
    private String name;
    private String surname;
    private int age;
    private double averageGrade;

    public Student(String name, String surname, int age, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    // переопреелим сравнение по содержимому
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // если это тот же объект
        if (obj == null || getClass() != obj.getClass()) return false; // проверка класса
        Student other = (Student) obj;
        return age == other.age &&
                Double.compare(other.averageGrade, averageGrade) == 0 &&
                name.equals(other.name) &&
                surname.equals(other.surname);
    }

    // переопределим хэш код
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (int) averageGrade; // просто добавляем оценку как целое
        return result;
}

    // Для удобного вывода информации о студенте
    @Override
    public String toString() {
        return name + " " + surname + ", возраст: " + age + ", ср. балл: " + averageGrade;
    }
}