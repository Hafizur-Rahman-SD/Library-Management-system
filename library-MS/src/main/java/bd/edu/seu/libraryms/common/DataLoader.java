package bd.edu.seu.libraryms.common;

import bd.edu.seu.libraryms.student.entity.Student;
import bd.edu.seu.libraryms.student.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentService studentService;

    public DataLoader(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {

        // jodi age theke data na thake tahole dummy create korbo
        if (studentService.findAll().isEmpty()) {

            Student s1 = new Student();
            s1.setStudentName("Aman");
            s1.setEmail("aman@gmail.com");
            s1.setMobile("9866577734");
            s1.setRegisterDate(LocalDate.now().toString());
            s1.setIdentityType("NID");
            s1.setStudentId("2022200000178");

            Student s2 = new Student();
            s2.setStudentName("Deepak");
            s2.setEmail("deepak@gmail.com");
            s2.setMobile("7695669776");
            s2.setRegisterDate(LocalDate.now().minusDays(5).toString());
            s2.setIdentityType("Student ID Card");
            s2.setStudentId("2022200000234");

            Student s3 = new Student();
            s3.setStudentName("Karim");
            s3.setEmail("karim@gmail.com");
            s3.setMobile("01710000000");
            s3.setRegisterDate(LocalDate.now().toString());
            s3.setIdentityType("NID");
            s3.setStudentId("2022200000456");



            studentService.save(s1);
            studentService.save(s2);
            studentService.save(s3);


            System.out.println("Dummy Students Loaded");
        }
    }
}
