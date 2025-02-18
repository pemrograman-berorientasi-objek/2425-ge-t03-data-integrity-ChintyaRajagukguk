package academic.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
 
 /**
  * @author 12S23023 Lenni Febriyani Hutape
  * @author 12S23045 Chintya Reginauli Rajagukguk
  */
 
 public class Driver2 {
 
     public static void main(String[] _args) {
         try (Scanner scanner = new Scanner(System.in)) {
             Map<String, Course> courses = new HashMap<>();
             Map<String, Student> students = new HashMap<>();
             ArrayList<Enrollment> enrollments = new ArrayList<>();
 
             while (true) {
                 String input = scanner.nextLine();
                 if (input.equals("---")) break;
                 String[] parts = input.split("#");
                 
                 switch (parts[0]) {
                     case "course-add":
                         if (!courses.containsKey(parts[1])) {  // Prevent duplicate course
                             courses.put(parts[1], new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                         }
                         break;
                     case "student-add":
                         if (!students.containsKey(parts[1])) {  // Prevent duplicate student
                             students.put(parts[1], new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                         }
                         break;
                     case "enrollment-add":
                         // Validate if the course and student exist before adding enrollment
                         if (courses.containsKey(parts[1]) && students.containsKey(parts[2])) {
                             enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                         } else {
                             if (!courses.containsKey(parts[1])) {
                                 System.out.println("invalid course|" + parts[1]);
                             }
                             if (!students.containsKey(parts[2])) {
                                 System.out.println("invalid student|" + parts[2]);
                             }
                         }
                         break;
                 }
             }
 
             // Output all courses, students, and enrollments
             for (Course course : courses.values()) {
                 System.out.println(course);
             }
             for (Student student : students.values()) {
                 System.out.println(student);
             }
             for (Enrollment enrollment : enrollments) {
                 System.out.println(enrollment);
             }
         }
     }
 }
 