package bd.edu.seu.libraryms.librarybook.service;

import bd.edu.seu.libraryms.librarybook.entity.LibraryBook;
import bd.edu.seu.libraryms.librarybook.repo.LibraryBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBookServiceImpl implements LibraryBookService {

    private final LibraryBookRepository repo;

    public LibraryBookServiceImpl(LibraryBookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<LibraryBook> findAll() {
        return repo.findAll();
    }

    @Override
    public LibraryBook findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public LibraryBook save(LibraryBook book) {
        return repo.save(book);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
