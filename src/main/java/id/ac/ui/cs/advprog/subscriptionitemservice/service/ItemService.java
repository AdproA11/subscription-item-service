package id.ac.ui.cs.advprog.subscriptionitemservice.service;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public CompletableFuture<Item> createItem(Item item) {
        return CompletableFuture.supplyAsync(() -> itemRepository.save(item));
    }

    // public CompletableFuture<Void> deleteItem(Long itemId) {
    //     return CompletableFuture.runAsync(() -> itemRepository.deleteById(itemId));
    // }

    public CompletableFuture<Item> updateItem(Long itemId, Item newItem) {
        return CompletableFuture.supplyAsync(() -> {
            return itemRepository.findById(itemId).map(item -> {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                return itemRepository.save(item);
            }).orElseThrow(() -> new RuntimeException("Item not found"));
        });
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item deleteItem(Long itemId) {
        // itemRepository.deleteById(itemId);
        Item item = this.getItemById(itemId);
        itemRepository.delete(item);
        return item;
    }

    public Item getItemById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id: " + id));
    }
}