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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "box_items",
        joinColumns = @JoinColumn(name = "box_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    public Box() {}

    public Box(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addItem(Item item) {
        items.add(item);
        item.getBoxes().add(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.getBoxes().remove(this);
    }
}