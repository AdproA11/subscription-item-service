package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<Item>> createItem(@RequestBody Item item) {
        return itemService.createItem(item)
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}/delete")
    public CompletableFuture<ResponseEntity<Item>> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return CompletableFuture.completedFuture(ResponseEntity.ok().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItembyId(@PathVariable Long id) {
        List<Item> items = itemService.getAllItems();
        for (Item item : items) {
            if (item.getId() == id) {
                return ResponseEntity.ok(item);
            }
        }
        Item itemObj = items.get(Math.toIntExact(id));
        return ResponseEntity.ok(itemObj);
    }

    // @DeleteMapping("/{id}/delete")
    // public ResponseEntity<Void> deleteItem(Long id) {
    //     // itemService.deleteItem(id);
    //     // return ResponseEntity.ok().build();
    //     Item item = getItem(id);
    //     itemService.deleteItem(item);
    //     return ResponseEntity.ok();
    // }
}