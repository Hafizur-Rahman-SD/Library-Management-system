package bd.edu.seu.libraryms.subscription.repo;

import bd.edu.seu.libraryms.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
}
