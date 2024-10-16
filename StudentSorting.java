
/*
 * Номер залікової книжки: 19
 * C11 (остача від ділення на 11): 8
 * Завдання: Визначити клас студент, який складається як мінімум з 5-и полів.
 */
import java.util.Arrays;
import java.util.Comparator;

class Student {
    private String name; // Ім'я студента
    private int age; // Вік студента
    private int gpa; // Середній бал студента
    private String major; // Спеціальність студента
    private int id; // Ідентифікаційний номер студента

    // Конструктор класу Student
    public Student(String name, int age, int gpa, String major, int id) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.major = major;
        this.id = id;
    }

    // Геттери для полів
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public int getId() {
        return id;
    }

    // Перевизначення методу toString для зручного виводу даних про студента
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                ", id=" + id +
                '}';
    }

    // Метод для порівняння двох студентів за ідентифікаційним номером
    public boolean equals(Student other) {
        return this.id == other.id;
    }
}

public class StudentSorting {
    public static void main(String[] args) {
        // Створення масиву студентів
        Student[] students = new Student[5];
        students[0] = new Student("Alice", 20, 78, "Computer Science", 1);
        students[1] = new Student("Bob", 22, 63, "Mathematics", 2);
        students[2] = new Student("Charlie", 21, 85, "Physics", 3);
        students[3] = new Student("David", 23, 94, "Chemistry", 4);
        students[4] = new Student("Eve", 20, 72, "Biology", 5);

        // Сортування за GPA (за зростанням)
        Arrays.sort(students, Comparator.comparingInt(Student::getGpa));
        System.out.println("Студенти, вiдсортованi за середнiм балом (за зростанням):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Сортування за віком (за спаданням)
        Arrays.sort(students, Comparator.comparingInt(Student::getAge).reversed());
        System.out.println("\nСтуденти, вiдсортованi за вiком (за спаданням):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Створення студенту для пошуку
        Student searchStudent = new Student("Bob", 22, 63, "Mathematics", 2);
        // Пошук студента в масиві
        boolean found = false;
        for (Student student : students) {
            if (student.equals(searchStudent)) {
                found = true;
                System.out.println("\nЗнайдений студент: " + student);
                break;
            }
        }

        if (!found) {
            System.out.println("\nСтудент не знайдений.");
        }
    }
}
