package bd.edu.seu.libraryms.vendor.repo;

import bd.edu.seu.libraryms.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor, Long> {
}
