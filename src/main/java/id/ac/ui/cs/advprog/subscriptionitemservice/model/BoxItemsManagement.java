package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class BoxItemsManagement {
    private ArrayList<Box> arrBox = new ArrayList<>();

    public void addBox(Box box) {
        arrBox.add(box);
    }

    public void deleteBox(Box box) {
        arrBox.remove(box);
    }

}

@Getter @Setter
class Box {
    private int id;
    private String name;
    private String description;
    private int price;
    private ArrayList<Item> arrItem = new ArrayList<>();

    public void addItem(Item item) {
        arrItem.add(item);
    }

    public void deleteItem(Item item) {
        arrItem.remove(item);
    }

    public void editBox(Box newBox) {
        this.name = newBox.getName();
        this.description = newBox.getDescription();
        this.price = newBox.getPrice();
    }
}

@Getter @Setter
class Item {
    private int id;
    private String name;
    private int amount;

    public void editItem(Item newItem) {
        this.name = newItem.getName();
        this.amount = newItem.getAmount();
    }
}
// recommit to new branch