import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // Добавляем студентов (2 с одинаковым GPA)
        students.put("S1", new Student("Ali", 3.5, 20));
        students.put("S2", new Student("Bek", 3.8, 21));
        students.put("S3", new Student("Aman", 3.5, 19)); // одинаковый GPA
        students.put("S4", new Student("Dina", 3.9, 22));
        students.put("S5", new Student("Ermek", 3.2, 20));

        // Печать всех студентов
        System.out.println("=== All Students ===");
        for (String id : students.keySet()) {
            System.out.println(id + " -> " + students.get(id));
        }

        // Найти по ID
        System.out.println("\nFind student S3:");
        System.out.println(students.get("S3"));

        // Удалить студента
        students.remove("S5");

        // Обновить GPA
        students.get("S1").setGpa(3.7);

        // ====================== SORTING ======================
        ArrayList<Student> list = new ArrayList<>(students.values());

        // 6a: сортировка по GPA (Comparable)
        Collections.sort(list);
        System.out.println("\nSorted by GPA:");
        for (Student s : list) {
            System.out.println(s);
        }

        // 6b: сортировка по имени
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by Name:");
        for (Student s : list) {
            System.out.println(s);
        }

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");

        ArrayList<Student> topList = new ArrayList<>(students.values());
        topList.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));

        for (int i = 0; i < Math.min(3, topList.size()); i++) {
            System.out.println(topList.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");

        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for (Student s : students.values()) {
            gpaMap.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaMap.get(s.getGpa()).add(s.getName());
        }

        for (Double gpa : gpaMap.keySet()) {
            if (gpaMap.get(gpa).size() > 1) {
                System.out.println("GPA " + gpa + " -> " + gpaMap.get(gpa));
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");

        HashMap<Course, List<Student>> courseMap = new HashMap<>();

        Course math = new Course("Math");
        Course java = new Course("Java");
        Course physics = new Course("Physics");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(java, new ArrayList<>());
        courseMap.put(physics, new ArrayList<>());

        courseMap.get(math).add(students.get("S1"));
        courseMap.get(math).add(students.get("S2"));

        courseMap.get(java).add(students.get("S3"));
        courseMap.get(java).add(students.get("S4"));

        courseMap.get(physics).add(students.get("S1"));

        for (Course c : courseMap.keySet()) {
            System.out.println(c + " -> " + courseMap.get(c));
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");

        ArrayList<Student> complexSort = new ArrayList<>(students.values());

        complexSort.sort((a, b) -> {
            int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
            if (gpaCompare == 0) {
                return a.getName().compareTo(b.getName());
            }
            return gpaCompare;
        });

        for (Student s : complexSort) {
            System.out.println(s);
        }
    }
}