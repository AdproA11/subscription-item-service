package id.ac.ui.cs.advprog.subscriptionitemservice.service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}