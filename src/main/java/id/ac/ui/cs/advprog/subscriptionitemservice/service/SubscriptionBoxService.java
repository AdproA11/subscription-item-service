package id.ac.ui.cs.advprog.subscriptionitemservice.service;

@Service
public class SubscriptionBoxService {
    @Autowired
    private SubscriptionBoxRepository subscriptionBoxRepository;

    public Box saveSubscriptionBox(Box subscriptionBox) {
        return subscriptionBoxRepository.save(subscriptionBox);
    }
}
