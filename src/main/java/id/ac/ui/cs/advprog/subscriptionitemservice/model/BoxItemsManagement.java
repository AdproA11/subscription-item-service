package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class BoxItemsManagement {
    private ArrayList<Box> arrBox = new ArrayList<>();

}

@Getter @Setter
class Box {
    private int id;
    private String name;
    private String description;
    private int price;
    private ArrayList<Items> arrItem = new ArrayList<>();
}

@Getter @Setter
class Items {
    private int id;
    private String name;
    private int jumlah;
}
// recommit to new branch