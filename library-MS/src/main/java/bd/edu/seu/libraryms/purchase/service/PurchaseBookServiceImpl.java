package bd.edu.seu.libraryms.purchase.service;

import bd.edu.seu.libraryms.purchase.entity.PurchaseBook;
import bd.edu.seu.libraryms.purchase.repo.PurchaseBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseBookServiceImpl implements PurchaseBookService {

    private final PurchaseBookRepo repo;

    public PurchaseBookServiceImpl(PurchaseBookRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<PurchaseBook> findAll() {
        return repo.findAll();
    }

    @Override
    public PurchaseBook save(PurchaseBook p) {
        return repo.save(p);
    }

    @Override
    public PurchaseBook findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
