package bd.edu.seu.libraryms.common;

import bd.edu.seu.libraryms.publication.entity.Publication;
import bd.edu.seu.libraryms.publication.repo.PublicationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PublicationDataLoader implements CommandLineRunner {

    private final PublicationRepo repo;

    public PublicationDataLoader(PublicationRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repo.count() == 0) {

            Publication p1 = new Publication();
            p1.setPublicationName("O'Reilly Media");
            p1.setCode("PUB-001");
            p1.setContactPerson("John Walker");
            p1.setEmail("info@oreilly.com");
            p1.setPhone("+1-555-123456");
            p1.setWebsite("https://www.oreilly.com");
            p1.setAddress("1005 Gravenstein Highway North, Sebastopol, CA");
            p1.setActive(true);
            p1.setCreatedAt(LocalDate.now().minusMonths(6));

            Publication p2 = new Publication();
            p2.setPublicationName("Pearson Education");
            p2.setCode("PUB-002");
            p2.setContactPerson("Emily Clark");
            p2.setEmail("support@pearson.com");
            p2.setPhone("+1-555-654321");
            p2.setWebsite("https://www.pearson.com");
            p2.setAddress("London, United Kingdom");
            p2.setActive(true);
            p2.setCreatedAt(LocalDate.now().minusMonths(3));

            Publication p3 = new Publication();
            p3.setPublicationName("McGraw-Hill");
            p3.setCode("PUB-003");
            p3.setContactPerson("Michael Scott");
            p3.setEmail("help@mcgrawhill.com");
            p3.setPhone("+1-555-998877");
            p3.setWebsite("https://www.mheducation.com");
            p3.setAddress("New York, USA");
            p3.setActive(false);
            p3.setCreatedAt(LocalDate.now().minusYears(1));

            repo.save(p1);
            repo.save(p2);
            repo.save(p3);

            System.out.println("Dummy Publication Data Loaded!");
        }
    }
}
