package bd.edu.seu.libraryms.inventory.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory_record")
public class InventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;
    private String bookCode;
    private String studentName;
    private String studentUniqueId;


    // ISSUE or RETURN
    private String actionType;
    private LocalDate actionDate;

    private Integer quantity;
    private String note;


    // system auto-calculated (ACTIVE / RETURNED)
    private String status;
    // DEFAULT CONSTRUCTOR
    public InventoryRecord() {
    }

//    public void updateStatus() {
//        if ("ISSUE".equalsIgnoreCase(actionType)) {
//            status = "ACTIVE";
//        } else if ("RETURN".equalsIgnoreCase(actionType)) {
//            status = "RETURNED";
//        } else {
//            status = "UNKNOWN";
//        }
//    }

    // getters + setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }


    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentUniqueId() {
        return studentUniqueId;
    }

    public void setStudentUniqueId(String studentUniqueId) {
        this.studentUniqueId = studentUniqueId;
    }
    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }

    public LocalDate getActionDate() { return actionDate; }
    public void setActionDate(LocalDate actionDate) { this.actionDate = actionDate; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
