package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoxItemsManagementTest {
    private BoxItemsManagement boxItemsManagement;
    private Box box;
    private Item item;

    @BeforeEach
    void setUp() {
        boxItemsManagement = new BoxItemsManagement();
        box = new Box();
        item = new Item();
    }

    @Test
    void testAddBox() {
        Box box = new Box();
        boxItemsManagement.addBox(box);
        assertTrue(boxItemsManagement.getArrBox().contains(box));
    }

    @Test
    void testAddItemsInBox() {
        Box box = new Box();
        Item item = new Item();
        boxItemsManagement.addBox(box);
        box.addItem(item);
        assertTrue(box.getArrItem().contains(item));
    }

    @Test
    void testEditBox() {
        Box box = new Box();
        boxItemsManagement.addBox(box);
        Box newBox = new Box();
        newBox.setId(1);
        box.editBox(newBox);
        assertEquals(newBox, box);
    }

    @Test
    void testDeleteBox() {
        Box box = new Box();
        boxItemsManagement.addBox(box);
        boxItemsManagement.deleteBox(box);
        assertFalse(boxItemsManagement.getArrBox().contains(box));
    }

    @Test
    void testEditItemsFromBox() {
        Box box = new Box();
        Item item = new Item();
        boxItemsManagement.addBox(box);
        box.addItem(item);
        Item newItem = new Item();
        box.getArrItem().get(1).editItem(item);
        assertEquals(newItem, box);
    }

    @Test
    void testDeleteItemsFromBox() {
        Box box = new Box();
        Item item = new Item();
        boxItemsManagement.addBox(box);
        box.addItem(item);
        box.deleteItem(item);
        assertFalse(box.getArrItem().contains(item));
    }
}
// recommit to new branch