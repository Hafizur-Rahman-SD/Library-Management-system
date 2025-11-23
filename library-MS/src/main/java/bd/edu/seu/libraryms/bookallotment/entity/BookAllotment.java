package bd.edu.seu.libraryms.bookallotment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book_allotments")
public class BookAllotment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;
    private String studentName;
    private String allotDate;
    private String status;
}
