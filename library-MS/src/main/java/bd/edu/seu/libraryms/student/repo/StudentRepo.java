package bd.edu.seu.libraryms.student.repo;

import bd.edu.seu.libraryms.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student, Long> {


}
