package bd.edu.seu.libraryms.publication.repo;

import bd.edu.seu.libraryms.publication.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepo extends JpaRepository<Publication, Long> {
}
