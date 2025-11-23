package bd.edu.seu.libraryms.student.controller;

import bd.edu.seu.libraryms.student.entity.Student;
import bd.edu.seu.libraryms.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("students", service.findAll());
        return "students/list";     // FIXED
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("student", new Student());
        return "students/create";   // FIXED
    }

    // EDIT PAGE
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Student s = service.findById(id);
        model.addAttribute("student", s);
        return "students/create";
    }

    // DELETE STUDENT
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/students/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student s) {
        service.save(s);
        return "redirect:/students/list";
    }
    // UPDATE STUDENT
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student updated) {
        Student s = service.findById(id);

        s.setStudentName(updated.getStudentName());
        s.setEmail(updated.getEmail());
        s.setMobile(updated.getMobile());
        s.setRegisterDate(updated.getRegisterDate());
        s.setStudentId(updated.getStudentId());
        s.setIdentityType(updated.getIdentityType());

        service.save(s);

        return "redirect:/students/list";
    }

}
