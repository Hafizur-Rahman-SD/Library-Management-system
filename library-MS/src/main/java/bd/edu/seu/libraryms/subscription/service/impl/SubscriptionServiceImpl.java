package bd.edu.seu.libraryms.subscription.service.impl;

import bd.edu.seu.libraryms.subscription.entity.Subscription;
import bd.edu.seu.libraryms.subscription.repo.SubscriptionRepo;
import bd.edu.seu.libraryms.subscription.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepo repo;

    public SubscriptionServiceImpl(SubscriptionRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Subscription> findAll() {
        return repo.findAll();
    }

    @Override
    public Subscription findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Subscription save(Subscription subscription) {
        return repo.save(subscription);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
