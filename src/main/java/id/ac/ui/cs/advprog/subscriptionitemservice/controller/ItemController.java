package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public CompletableFuture<ResponseEntity<Item>> createItem(@RequestBody Item item) {
        return itemService.createItem(item)
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id)
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Item>> updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}