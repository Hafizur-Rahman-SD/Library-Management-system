package bd.edu.seu.libraryms.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String email;
    private String mobile;
    private String registerDate;
    private String studentId;      // 2022200000178 style ID

    private String identityType;   //  NEW FIELD (for form select)
}
