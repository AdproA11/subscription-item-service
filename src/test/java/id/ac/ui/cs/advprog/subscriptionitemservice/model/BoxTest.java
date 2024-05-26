package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    private Box box;

    @BeforeEach
    void setUp() {
        box = new Box("Test Box", "Test Description", 10.0);
    }

    @Test
    void testAddItemWithNameAndDescription() {
        box.addItem("Item 1", "Item 1 Description");
        assertEquals(1, box.getItems().size());
    }

    @Test
    void testAddItem() {
        Item item = new Item("Item 1", "Item 1 Description");
        box.addItem(item);
        assertEquals(1, box.getItems().size());
    }

    @Test
    void testRemoveItem() {
        Item item = new Item("Item 1", "Item 1 Description");
        box.addItem(item);
        box.removeItem(item);
        assertEquals(0, box.getItems().size());
    }
}