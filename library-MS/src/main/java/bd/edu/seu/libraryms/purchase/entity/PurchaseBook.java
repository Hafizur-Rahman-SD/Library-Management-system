package bd.edu.seu.libraryms.purchase.entity;

import bd.edu.seu.libraryms.vendor.entity.Vendor;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "purchase_book")
public class PurchaseBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private int quantity;

    private double pricePerBook;

    private LocalDate purchaseDate;

    private String invoiceNumber;
}
