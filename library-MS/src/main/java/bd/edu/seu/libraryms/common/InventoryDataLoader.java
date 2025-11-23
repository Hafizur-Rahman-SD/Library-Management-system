package bd.edu.seu.libraryms.common;

import bd.edu.seu.libraryms.inventory.entity.InventoryRecord;
import bd.edu.seu.libraryms.inventory.repo.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InventoryDataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    public InventoryDataLoader(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void run(String... args) {

        if (inventoryRepository.findAll().isEmpty()) {

            InventoryRecord r1 = new InventoryRecord();
            r1.setBookTitle("The Book Thief");
            r1.setStudentName("Smita");
            r1.setQuantity(1);
            r1.setActionType("ISSUE");
            r1.setActionDate(LocalDate.now().minusDays(3));
            r1.setStatus("Completed");

            InventoryRecord r2 = new InventoryRecord();
            r2.setBookTitle("A Story of Yest");
            r2.setStudentName("Robinson H");
            r2.setQuantity(1);
            r2.setActionType("RETURN");
            r2.setActionDate(LocalDate.now().minusDays(10));
            r2.setStatus("Completed");

            InventoryRecord r3 = new InventoryRecord();
            r3.setBookTitle("TestBook");
            r3.setStudentName("Pradeep");
            r3.setQuantity(2);
            r3.setActionType("ISSUE");
            r3.setActionDate(LocalDate.now().minusDays(1));
            r3.setStatus("Pending");

            inventoryRepository.save(r1);
            inventoryRepository.save(r2);
            inventoryRepository.save(r3);

            System.out.println("Dummy Inventory Data Loaded");
        }
    }
}
