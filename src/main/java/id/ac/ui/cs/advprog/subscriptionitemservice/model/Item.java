package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Box> boxes = new ArrayList<>();

    public Item() {}

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
}