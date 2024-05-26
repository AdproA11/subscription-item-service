package id.ac.ui.cs.advprog.subscriptionitemservice.service;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public CompletableFuture<Item> createItem(Item item) {
        return CompletableFuture.supplyAsync(() -> itemRepository.save(item));
    }

    public CompletableFuture<Item> updateItem(Long id, Item newItem) {
        return CompletableFuture.supplyAsync(() -> {
            return itemRepository.findById(id).map(item -> {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                return itemRepository.save(item);
            }).orElseThrow(() -> new RuntimeException("Item not found"));
        });
    }

    public CompletableFuture<Void> deleteItem(Long id) {
        return CompletableFuture.runAsync(() -> {
            Item item = getItemById(id);
            itemRepository.delete(item);
        });
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid item Id: " + id));
    }
}
