package bd.edu.seu.libraryms.purchase.service;

import bd.edu.seu.libraryms.purchase.entity.PurchaseBook;

import java.util.List;

public interface PurchaseBookService {

    List<PurchaseBook> findAll();

    PurchaseBook save(PurchaseBook p);

    PurchaseBook findById(Long id);

    void delete(Long id);
}
