package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

@RestController
@RequestMapping("/api/subscription-boxes")
public class SubscriptionBoxController {
    @Autowired
    private SubscriptionBoxService subscriptionBoxService;

    @PostMapping("/")
    public ResponseEntity<SubscriptionBox> createSubscriptionBox(@RequestBody SubscriptionBox subscriptionBox) {
        return new ResponseEntity<>(subscriptionBoxService.saveSubscriptionBox(subscriptionBox), HttpStatus.CREATED);
    }
}