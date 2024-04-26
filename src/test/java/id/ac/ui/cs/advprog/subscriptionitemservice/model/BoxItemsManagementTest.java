package id.ac.ui.cs.advprog.subscriptionitemservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoxItemsManagementTest {
    private BoxItemsManagement boxItemsManagement;

    @BeforeEach
    void setUp() {
        boxItemsManagement = new BoxItemsManagement();
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
        Items item = new Items();
        boxItemsManagement.addBox(box);
        boxItemsManagement.addItemsInBox(box, item);
        assertTrue(box.getArrItem().contains(item));
    }

    @Test
    void testEditBox() {
        Box box = new Box();
        boxItemsManagement.addBox(box);
        Box newBox = new Box();
        newBox.setId(1);
        boxItemsManagement.editBox(box, newBox);
        assertEquals(newBox, boxItemsManagement.getArrBox().get(0));
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
        Items item = new Items();
        boxItemsManagement.addBox(box);
        boxItemsManagement.addItemsInBox(box, item);
        Items newItem = new Items();
        newItem.setId(1);
        boxItemsManagement.editItemsFromBox(box, item, newItem);
        assertEquals(newItem, box.getArrItem().get(0));
    }

    @Test
    void testDeleteItemsFromBox() {
        Box box = new Box();
        Items item = new Items();
        boxItemsManagement.addBox(box);
        boxItemsManagement.addItemsInBox(box, item);
        boxItemsManagement.deleteItemsFromBox(box, item);
        assertFalse(box.getArrItem().contains(item));
    }
}
// recommit to new branch