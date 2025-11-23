package bd.edu.seu.libraryms.publication.service;

import bd.edu.seu.libraryms.publication.entity.Publication;

import java.util.List;

public interface PublicationService {

    List<Publication> findAll();

    Publication findById(Long id);

    Publication save(Publication publication);

    void delete(Long id);
}
