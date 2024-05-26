package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {
    @Autowired
    private BoxService boxService;

    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<Box>> createBox(@RequestBody Box box) {
        return boxService.createBox(box)
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteBox(@PathVariable Long id) {
        return boxService.deleteBox(id)
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Box>> updateBox(@PathVariable Long id, @RequestBody Box box) {
        return boxService.updateBox(id, box)
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping("/{id}/items")
    public CompletableFuture<ResponseEntity<Box>> addItemsToBox(@PathVariable Long id, @RequestBody List<Item> items) {
        return boxService.addItemsToBox(id, items)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Box>> getAllBoxes() {
        List<Box> boxes = boxService.getAllBoxes();
        return ResponseEntity.ok(boxes);
    }
}