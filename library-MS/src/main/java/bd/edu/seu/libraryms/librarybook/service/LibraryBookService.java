package bd.edu.seu.libraryms.librarybook.service;

import bd.edu.seu.libraryms.librarybook.entity.LibraryBook;

import java.util.List;

public interface LibraryBookService {
    List<LibraryBook> findAll();
    LibraryBook findById(Long id);
    LibraryBook save(LibraryBook book);
    void deleteById(Long id);
}
