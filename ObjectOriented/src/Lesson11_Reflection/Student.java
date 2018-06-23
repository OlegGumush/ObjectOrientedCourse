package Lesson11_Reflection;

public class Student {

    private int id, year;
    private String name;
    private String department;
    private static int numOfStudents = 0;

    public Student() {
    }

    public Student(String name, int id, String department, int year) {
        if (name.equals("")) {
            throw new RuntimeException("name is empty!!!");
        }
        this.name = name;
        this.year = year;
        this.id = id;
        this.department = department;
        numOfStudents++;
    }

    public Student(Student st) {
        this(st.name, st.id, st.department, st.year);
        numOfStudents++;
    }

    public static int getNumStudents() {
        return numOfStudents;
    }

    public String toString() {
        return name + ", id: " + id + ", department " + department + ", year" + year;
    }

    private int fun() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Student s1 = new Student("Haiim", 1, "Computer Science", 1);
        Student s2 = new Student("Rachel", 2, "Computer Science", 1);
        Student s3 = new Student("Moshe", 3, "Phisics", 2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("number of students: " + Student.getNumStudents());
        Student s4 = new Student("Lea", 4, "Chemistry", 3);
        System.out.println(s4);
        System.out.println("number of students: " + Student.getNumStudents());
    }
}
