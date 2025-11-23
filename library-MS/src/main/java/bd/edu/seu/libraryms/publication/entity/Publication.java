package bd.edu.seu.libraryms.publication.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String publicationName;
    private String code;
    private String contactPerson;
    private String email;
    private String phone;
    private String website;
    private String address;

    private Boolean active = true;

    private LocalDate createdAt = LocalDate.now();
}
