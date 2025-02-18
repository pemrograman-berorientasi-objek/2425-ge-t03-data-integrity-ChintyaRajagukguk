package academic.driver;

import java.util.ArrayList;
import java.util.Scanner;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;

/**
 * @author 12S23023 Lenni Febriyani Hutape
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */
public class Driver1 {

    public static void main(String[] _args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Course> courses = new ArrayList<>();
            ArrayList<Student> students = new ArrayList<>();
            ArrayList<Enrollment> enrollments = new ArrayList<>();

            while (true) {
                String input = scanner.nextLine();
                if (input.equals("---")) break;
                String[] parts = input.split("#");
                
                switch (parts[0]) {
                    case "course-add":
                        courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                        break;
                    case "student-add":
                        students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                        break;
                    case "enrollment-add":
                        // Cek apakah course dan student valid
                        boolean courseExists = false;
                        boolean studentExists = false;

                        // Cek apakah course ada
                        for (Course course : courses) {
                            if (course.getCode().equals(parts[1])) {
                                courseExists = true;
                                break;
                            }
                        }

                        // Cek apakah student ada
                        for (Student student : students) {
                            if (student.getId().equals(parts[2])) {
                                studentExists = true;
                                break;
                            }
                        }

                        // Jika course atau student tidak ditemukan, tampilkan invalid message
                        if (!courseExists) {
                            System.out.println("invalid course|" + parts[1]);
                        } else if (!studentExists) {
                            System.out.println("invalid student|" + parts[2]);
                        } else {
                            // Jika valid, tambah enrollment
                            enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                        }
                        break;
                }
            }

            // Tampilkan data course, student, dan enrollment
            for (Course course : courses) {
                System.out.println(course);
            }
            for (Student student : students) {
                System.out.println(student);
            }
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment);
            }
        }
    }
}
