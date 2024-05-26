package id.ac.ui.cs.advprog.subscriptionitemservice.service;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.BoxRepository;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private ItemRepository itemRepository;

    public CompletableFuture<Box> createBox(Box box) {
        return CompletableFuture.supplyAsync(() -> boxRepository.save(box));
    }

    public CompletableFuture<Void> deleteBox(Long boxId) {
        return CompletableFuture.runAsync(() -> boxRepository.deleteById(boxId));
    }

    public CompletableFuture<Box> updateBox(Long boxId, Box newBox) {
        return CompletableFuture.supplyAsync(() -> {
            return boxRepository.findById(boxId).map(box -> {
                box.setName(newBox.getName());
                box.setDescription(newBox.getDescription());
                box.setPrice(newBox.getPrice());
                box.setItems(newBox.getItems());
                return boxRepository.save(box);
            }).orElseThrow(() -> new RuntimeException("Box tidak ditemukan"));
        });
    }

    public CompletableFuture<Box> addItemsToBox(Long boxId, List<Item> items) {
        return CompletableFuture.supplyAsync(() -> {
            Box box = boxRepository.findById(boxId).orElseThrow(() -> new RuntimeException("Box tidak ditemukan"));
            items.forEach(box::addItem);
            return boxRepository.save(box);
        });
    }

    public Box saveSubscriptionBox(Box subscriptionBox) {
        return boxRepository.save(subscriptionBox);
    }

    public List<Box> getAllBoxes() {
        return boxRepository.findAll();
    }
}