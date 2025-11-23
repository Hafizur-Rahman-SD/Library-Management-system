package bd.edu.seu.libraryms.common;

import bd.edu.seu.libraryms.purchase.entity.PurchaseBook;
import bd.edu.seu.libraryms.purchase.repo.PurchaseBookRepo;
import bd.edu.seu.libraryms.vendor.entity.Vendor;
import bd.edu.seu.libraryms.vendor.repo.VendorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PurchaseDataLoader implements CommandLineRunner {

    private final PurchaseBookRepo purchaseRepo;
    private final VendorRepo vendorRepo;

    public PurchaseDataLoader(PurchaseBookRepo purchaseRepo, VendorRepo vendorRepo) {
        this.purchaseRepo = purchaseRepo;
        this.vendorRepo = vendorRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (purchaseRepo.count() == 0) {

            //  Dummy Vendor 1
            Vendor v1 = new Vendor();
            v1.setVendorName("ABC Vendor");
            v1.setCompany("ABC Publications");
            v1.setPhone("01711223344");
            v1.setEmail("abc.vendor@gmail.com");
            v1.setAddress("Dhaka, Bangladesh");
            vendorRepo.save(v1);

            //  Dummy Vendor 2
            Vendor v2 = new Vendor();
            v2.setVendorName("Global Books Co.");
            v2.setCompany("Global Books Ltd.");
            v2.setPhone("01844556677");
            v2.setEmail("globalbooks@gmail.com");
            v2.setAddress("Chittagong, Bangladesh");
            vendorRepo.save(v2);

            //Purchase Book 1
            PurchaseBook p1 = new PurchaseBook();
            p1.setBookName("The Book Thief");
            p1.setVendor(v1);
            p1.setQuantity(10);
            p1.setPricePerBook(250.00);
            p1.setPurchaseDate(LocalDate.now().minusDays(12));
            p1.setInvoiceNumber("INV-1001");
            purchaseRepo.save(p1);

            //  Purchase Book 2
            PurchaseBook p2 = new PurchaseBook();
            p2.setBookName("A Story of Yest");
            p2.setVendor(v2);
            p2.setQuantity(6);
            p2.setPricePerBook(180.00);
            p2.setPurchaseDate(LocalDate.now().minusDays(30));
            p2.setInvoiceNumber("INV-1002");
            purchaseRepo.save(p2);

            // Purchase Book 3
            PurchaseBook p3 = new PurchaseBook();
            p3.setBookName("Educated");
            p3.setVendor(v1);
            p3.setQuantity(15);
            p3.setPricePerBook(300.00);
            p3.setPurchaseDate(LocalDate.now().minusDays(5));
            p3.setInvoiceNumber("INV-1003");
            purchaseRepo.save(p3);

            System.out.println("Dummy PurchaseBook & Vendor Data Loaded Successfully!");
        }
    }
}
