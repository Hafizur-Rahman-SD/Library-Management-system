package bd.edu.seu.libraryms.subscription.service;

import bd.edu.seu.libraryms.subscription.entity.Subscription;
import java.util.List;

public interface SubscriptionService {

    List<Subscription> findAll();

    Subscription findById(Long id);

    Subscription save(Subscription subscription);

    void delete(Long id);
}
