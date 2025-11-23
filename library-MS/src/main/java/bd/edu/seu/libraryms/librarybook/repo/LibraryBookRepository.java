package bd.edu.seu.libraryms.librarybook.repo;

import bd.edu.seu.libraryms.librarybook.entity.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
}
