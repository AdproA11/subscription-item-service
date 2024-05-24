package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

@RestController
@RequestMapping("/api/subscription-boxes")
public class SubscriptionBoxController {
    @Autowired
    private SubscriptionBoxService subscriptionBoxService;

    @PostMapping("/")
    public ResponseEntity<Box> createSubscriptionBox(@RequestBody Box subscriptionBox) {
        return new ResponseEntity<>(subscriptionBoxService.saveSubscriptionBox(subscriptionBox), HttpStatus.CREATED);
    }
}