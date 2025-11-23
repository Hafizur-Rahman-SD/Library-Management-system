package bd.edu.seu.libraryms.student.service;

import bd.edu.seu.libraryms.student.entity.Student;
import java.util.List;


public interface StudentService {
    List<Student> findAll();
    Student save(Student s);
    Student findById(Long id);
    void deleteById(Long id);

}
