package bd.edu.seu.libraryms.student.service;

import bd.edu.seu.libraryms.student.entity.Student;
import bd.edu.seu.libraryms.student.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;

    public StudentServiceImpl(StudentRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Student save(Student s) {
        return repo.save(s);
    }

    @Override
    public Student findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
