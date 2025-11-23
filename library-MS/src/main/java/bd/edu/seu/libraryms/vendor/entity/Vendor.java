package bd.edu.seu.libraryms.vendor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String company;
    private String phone;
    private String email;
    private String address;
}
