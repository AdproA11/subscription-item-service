package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "box_id")
    private List<Item> items = new ArrayList<>();

    public Box() {
    }

    public Box(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addItem(String name, String description) {
        Item newItem = new Item(name, description);
        items.add(newItem);
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}