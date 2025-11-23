package bd.edu.seu.libraryms.common;

import bd.edu.seu.libraryms.subscription.entity.Subscription;
import bd.edu.seu.libraryms.subscription.repo.SubscriptionRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDataLoader implements CommandLineRunner {

    private final SubscriptionRepo repo;

    public SubscriptionDataLoader(SubscriptionRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repo.count() == 0) {

            Subscription s1 = new Subscription();
            s1.setTitle("Weekly");
            s1.setAmount(100.0);
            s1.setNumberOfDays(7);

            Subscription s2 = new Subscription();
            s2.setTitle("Monthly");
            s2.setAmount(500.0);
            s2.setNumberOfDays(30);

            Subscription s3 = new Subscription();
            s3.setTitle("Yearly");
            s3.setAmount(5500.0);
            s3.setNumberOfDays(365);

            repo.save(s1);
            repo.save(s2);
            repo.save(s3);

            System.out.println("Dummy Subscription Loaded!");
        }
    }
}
