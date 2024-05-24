package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BoxItemsManagementTest {
    private BoxItem boxItemsManagement;
    private Box box;
    private Item item;

    @BeforeEach
    void setUp() {
        boxItemsManagement = new BoxItem();
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

    @Test
    void testGetAllBoxes() {
        boxItemsManagement.addBox(box1);
        boxItemsManagement.addBox(box2);

        ArrayList<Box> boxes = boxItemsManagement.getArrBox();

        assertTrue(boxes.contains(box1));
        assertTrue(boxes.contains(box2));
    }

    @Test
    void testGetAllItems() {
        box.addItem(item1);
        box.addItem(item2);

        ArrayList<Item> items = box.getArrItem();

        assertTrue(items.contains(item1));
        assertTrue(items.contains(item2));
    }
}
