import java.util.*;

class Student {
    private String name;
    private List<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }
}

class Gradebook {
    private List<Student> students;

    public Gradebook() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void enterGrade(String studentName, int grade) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                student.addGrade(grade);
                return;
            }
        }
        System.out.println("Student not found: " + studentName);
    }

    public double getStudentAverageGrade(String studentName) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                return student.calculateAverageGrade();
            }
        }
        System.out.println("Student not found: " + studentName);
        return 0.0;
    }

    public void generateGradeReport() {
        System.out.println("Grade Report:");
        for (Student student : students) {
            double avgGrade = student.calculateAverageGrade();
            System.out.println(student.getName() + " - Average Grade: " + avgGrade);
            System.out.println("Grades: " + student.getGrades());
            System.out.println(); 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();

    
        Student student1 = new Student("Sivanaveen");
        Student student2 = new Student("Ravivarma");
        Student student3 = new Student("Vaseekaran");
        Student student4 = new Student("Santhosh Kumar");
        Student student5 = new Student("Bijo");
        gradebook.addStudent(student1);
        gradebook.addStudent(student2);
        gradebook.addStudent(student3);
        gradebook.addStudent(student4);
        gradebook.addStudent(student5);
        System.out.println(); 
        gradebook.enterGrade("Siva", 85);
        System.out.println();
        gradebook.enterGrade("Sivanaveen", 85);
        gradebook.enterGrade("Sivanaveen", 90);
        gradebook.enterGrade("Ravivarma", 75);
        gradebook.enterGrade("Ravivarma", 80);
        gradebook.enterGrade("Sivanaveen", 85);
        gradebook.enterGrade("Sivanaveen", 89);
        gradebook.enterGrade("Vaseekaran", 93);
        gradebook.enterGrade("Bijo", 98);
        gradebook.enterGrade("Sivanaveen", 95);
        gradebook.enterGrade("Vaseekaran", 75);
        gradebook.enterGrade("Bijo", 87);
        


        gradebook.generateGradeReport();
    }
}
