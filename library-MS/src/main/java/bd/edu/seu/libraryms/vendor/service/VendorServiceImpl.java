package bd.edu.seu.libraryms.vendor.service;

import bd.edu.seu.libraryms.vendor.entity.Vendor;
import bd.edu.seu.libraryms.vendor.repo.VendorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepo repo;

    public VendorServiceImpl(VendorRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Vendor> findAll() {
        return repo.findAll();
    }

    @Override
    public Vendor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Vendor save(Vendor vendor) {
        return repo.save(vendor);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
