package bd.edu.seu.libraryms.vendor.service;

import bd.edu.seu.libraryms.vendor.entity.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> findAll();
    Vendor findById(Long id);
    Vendor save(Vendor vendor);
    void delete(Long id);
}
