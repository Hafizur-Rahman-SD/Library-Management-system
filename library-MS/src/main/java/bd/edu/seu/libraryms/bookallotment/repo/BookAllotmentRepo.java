package bd.edu.seu.libraryms.bookallotment.repo;

import bd.edu.seu.libraryms.bookallotment.entity.BookAllotment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAllotmentRepo extends JpaRepository<BookAllotment, Long> {}
