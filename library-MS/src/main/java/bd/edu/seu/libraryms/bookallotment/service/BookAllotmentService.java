package bd.edu.seu.libraryms.bookallotment.service;

import bd.edu.seu.libraryms.bookallotment.entity.BookAllotment;
import java.util.List;

public interface BookAllotmentService {

    List<BookAllotment> getAll();
    BookAllotment save(BookAllotment a);
    BookAllotment getById(Long id);
    void delete(Long id);
}
