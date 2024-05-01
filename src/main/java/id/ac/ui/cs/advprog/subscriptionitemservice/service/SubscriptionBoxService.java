package id.ac.ui.cs.advprog.subscriptionitemservice.service;

@Service
public class SubscriptionBoxService {
    @Autowired
    private SubscriptionBoxRepository subscriptionBoxRepository;

    public SubscriptionBox saveSubscriptionBox(SubscriptionBox subscriptionBox) {
        return subscriptionBoxRepository.save(subscriptionBox);
    }
}
