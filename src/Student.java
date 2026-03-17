public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // Конструктор
    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // Изменение GPA
    public void setGpa(double newGpa) {
        this.gpa = newGpa;
    }


    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", GPA: " + gpa + ", Age: " + age;
    }
}