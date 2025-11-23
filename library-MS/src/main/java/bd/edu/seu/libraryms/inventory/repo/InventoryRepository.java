package bd.edu.seu.libraryms.inventory.repo;

import bd.edu.seu.libraryms.inventory.entity.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface InventoryRepository extends JpaRepository<InventoryRecord, Long> {

    @Query("""
            SELECT r.bookTitle, r.studentName, r.studentUniqueId,
                   r.actionType, r.actionDate, r.quantity, r.status
            FROM InventoryRecord r
            WHERE r.actionDate BETWEEN :start AND :end
            """)
    List<Object[]> getAllotmentReport(@Param("start") LocalDate start,
                                      @Param("end") LocalDate end);


}
