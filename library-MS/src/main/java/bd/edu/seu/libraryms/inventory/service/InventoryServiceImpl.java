package bd.edu.seu.libraryms.inventory.service;

import bd.edu.seu.libraryms.inventory.entity.InventoryRecord;
import bd.edu.seu.libraryms.inventory.repo.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository repo;

    public InventoryServiceImpl(InventoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<InventoryRecord> findAll() {
        // sob record list view er jonno
        return repo.findAll();
    }

    @Override
    public InventoryRecord save(InventoryRecord record) {
        // status already controller theke set hoye ase
        // ekhane sudhu DB te save korbo
        return repo.save(record);
    }

    @Override
    public InventoryRecord findById(Long id) {
        // edit form e show korar jonno specific record
        Optional<InventoryRecord> opt = repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void delete(Long id) {
        // delete button click korle record delete
        repo.deleteById(id);
    }
}
