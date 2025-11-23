package bd.edu.seu.libraryms.inventory.service;

import bd.edu.seu.libraryms.inventory.entity.InventoryRecord;
import java.util.List;

public interface InventoryService {

    List<InventoryRecord> findAll();

    InventoryRecord save(InventoryRecord record);

    InventoryRecord findById(Long id);

    void delete(Long id);
}
