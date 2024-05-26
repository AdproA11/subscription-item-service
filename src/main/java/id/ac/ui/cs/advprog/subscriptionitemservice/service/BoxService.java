package id.ac.ui.cs.advprog.subscriptionitemservice.service;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.BoxRepository;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private ItemRepository itemRepository;

    public CompletableFuture<Box> createOrUpdateBox(Box box) {
        return CompletableFuture.supplyAsync(() -> {
            List<Item> managedItems = box.getItems().stream()
                .map(item -> {
                    if (item.getId() != null && itemRepository.existsById(item.getId())) {
                        Item existingItem = itemRepository.findById(item.getId()).get();
                        existingItem.setName(item.getName());
                        existingItem.setDescription(item.getDescription());
                        return itemRepository.save(existingItem); 
                    } else {
                        return itemRepository.save(item); 
                    }
                })
                .collect(Collectors.toList());
            box.setItems(managedItems);
            return boxRepository.save(box);
        });
    }

    public CompletableFuture<Void> deleteBox(Long id) {
        return CompletableFuture.runAsync(() -> {
            if (boxRepository.existsById(id)) {
                boxRepository.deleteById(id);
            }
        });
    }

    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }
}
