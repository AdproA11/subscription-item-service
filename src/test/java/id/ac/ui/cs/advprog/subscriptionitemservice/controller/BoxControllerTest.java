package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.service.BoxService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BoxControllerTest {
    @Mock
    private BoxService boxService;

    @InjectMocks
    private BoxController boxController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateBox() {
        Box box = new Box("Test Box", "Test Description", 10.0);
        CompletableFuture<ResponseEntity<Box>> futureResponse = CompletableFuture.completedFuture(ResponseEntity.ok(box));
        // when(boxService.createBox(box)).thenReturn(futureResponse);

        CompletableFuture<ResponseEntity<Box>> response = boxController.createBox(box);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.join().getStatusCode());
        assertEquals(box, response.join().getBody());
        verify(boxService, times(1)).createBox(box);
    }

    @Test
    void testDeleteBox() {
        Long boxId = 1L;
        CompletableFuture<ResponseEntity<Void>> futureResponse = CompletableFuture.completedFuture(ResponseEntity.ok().build());
        // when(boxService.deleteBox(boxId)).thenReturn(futureResponse);

        CompletableFuture<ResponseEntity<Void>> response = boxController.deleteBox(boxId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.join().getStatusCode());
        verify(boxService, times(1)).deleteBox(boxId);
    }

    @Test
    void testUpdateBox() {
        Long boxId = 1L;
        Box box = new Box("Test Box", "Test Description", 10.0);
        CompletableFuture<ResponseEntity<Box>> futureResponse = CompletableFuture.completedFuture(ResponseEntity.ok(box));
        // when(boxService.updateBox(boxId, box)).thenReturn(futureResponse);

        CompletableFuture<ResponseEntity<Box>> response = boxController.updateBox(boxId, box);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.join().getStatusCode());
        assertEquals(box, response.join().getBody());
        verify(boxService, times(1)).updateBox(boxId, box);
    }

    @Test
    void testAddItemsToBox() {
        Long boxId = 1L;
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", "Item 1 Description"));
        items.add(new Item("Item 2", "Item 2 Description"));
        Box box = new Box("Test Box", "Test Description", 10.0);
        CompletableFuture<ResponseEntity<Box>> futureResponse = CompletableFuture.completedFuture(ResponseEntity.ok(box));
        // when(boxService.addItemsToBox(boxId, items)).thenReturn(futureResponse);

        CompletableFuture<ResponseEntity<Box>> response = boxController.addItemsToBox(boxId, items);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.join().getStatusCode());
        assertEquals(box, response.join().getBody());
        verify(boxService, times(1)).addItemsToBox(boxId, items);
    }

    @Test
    void testGetAllBoxes() {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("Box 1", "Description 1", 10.0));
        boxes.add(new Box("Box 2", "Description 2", 20.0));
        when(boxService.getAllBoxes()).thenReturn(boxes);

        ResponseEntity<List<Box>> response = boxController.getAllBoxes();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(boxes, response.getBody());
        verify(boxService, times(1)).getAllBoxes();
    }
}