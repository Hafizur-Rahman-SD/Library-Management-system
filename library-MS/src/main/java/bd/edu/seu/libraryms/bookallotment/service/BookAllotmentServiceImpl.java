package bd.edu.seu.libraryms.bookallotment.service;

import bd.edu.seu.libraryms.bookallotment.entity.BookAllotment;
import bd.edu.seu.libraryms.bookallotment.repo.BookAllotmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAllotmentServiceImpl implements BookAllotmentService {

    private final BookAllotmentRepo repo;

    public BookAllotmentServiceImpl(BookAllotmentRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<BookAllotment> getAll() {
        return repo.findAll();
    }

    @Override
    public BookAllotment save(BookAllotment a) {
        return repo.save(a);
    }

    @Override
    public BookAllotment getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
