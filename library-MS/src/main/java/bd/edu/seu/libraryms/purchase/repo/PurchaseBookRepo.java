package bd.edu.seu.libraryms.purchase.repo;

import bd.edu.seu.libraryms.purchase.entity.PurchaseBook;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;


public interface PurchaseBookRepo extends JpaRepository<PurchaseBook, Long> {


    @Query("""
            SELECT p.bookName, p.quantity, p.pricePerBook, p.purchaseDate
            FROM PurchaseBook p
            WHERE p.purchaseDate BETWEEN :start AND :end
            """)
    List<Object[]> getPurchaseReport(@Param("start") LocalDate start,
                                     @Param("end") LocalDate end);

}
