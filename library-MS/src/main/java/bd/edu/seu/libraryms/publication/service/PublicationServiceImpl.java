package bd.edu.seu.libraryms.publication.service;

import bd.edu.seu.libraryms.publication.entity.Publication;
import bd.edu.seu.libraryms.publication.repo.PublicationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepo repo;

    public PublicationServiceImpl(PublicationRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Publication> findAll() {
        return repo.findAll();
    }

    @Override
    public Publication findById(Long id) {
        Optional<Publication> opt = repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Publication save(Publication publication) {
        return repo.save(publication);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
