package bd.edu.seu.libraryms.subscription.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // subscription title
    private Double amount;       // price in €
    private Integer numberOfDays;

    private Boolean active = true;

    private LocalDate createdAt = LocalDate.now();
}
