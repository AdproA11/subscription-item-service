// package id.ac.ui.cs.advprog.subscriptionitemservice.service;

// import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
// import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
// import id.ac.ui.cs.advprog.subscriptionitemservice.repository.BoxRepository;
// import id.ac.ui.cs.advprog.subscriptionitemservice.repository.ItemRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.concurrent.CompletableFuture;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// class BoxServiceTest {
//     @Mock
//     private BoxRepository boxRepository;

//     @Mock
//     private ItemRepository itemRepository;

//     @InjectMocks
//     private BoxService boxService;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     void testCreateBox() {
//         Box box = new Box("Test Box", "Test Description", 10.0);
//         when(boxRepository.save(box)).thenReturn(box);

//         CompletableFuture<Box> futureBox = boxService.createBox(box);

//         assertNotNull(futureBox);
//         assertEquals(box, futureBox.join());
//         verify(boxRepository, times(1)).save(box);
//     }

//     @Test
//     void testDeleteBox() {
//         Long boxId = 1L;
//         doNothing().when(boxRepository).deleteById(boxId);

//         CompletableFuture<Void> futureVoid = boxService.deleteBox(boxId);

//         assertNotNull(futureVoid);
//         assertDoesNotThrow(() -> futureVoid.get());
//         verify(boxRepository, times(1)).deleteById(boxId);
//     }

//     @Test
//     void testUpdateBox() {
//         Long boxId = 1L;
//         Box existingBox = new Box("Existing Box", "Existing Description", 20.0);
//         Box newBox = new Box("New Box", "New Description", 30.0);
//         when(boxRepository.findById(boxId)).thenReturn(Optional.of(existingBox));
//         when(boxRepository.save(existingBox)).thenReturn(existingBox);

//         CompletableFuture<Box> futureBox = boxService.updateBox(boxId, newBox);

//         assertNotNull(futureBox);
//         assertEquals(existingBox, futureBox.join());
//         assertEquals(newBox.getName(), existingBox.getName());
//         assertEquals(newBox.getDescription(), existingBox.getDescription());
//         assertEquals(newBox.getPrice(), existingBox.getPrice());
//         verify(boxRepository, times(1)).findById(boxId);
//         verify(boxRepository, times(1)).save(existingBox);
//     }

//     @Test
//     void testAddItemsToBox() {
//         Long boxId = 1L;
//         Box box = new Box("Test Box", "Test Description", 10.0);
//         List<Item> items = new ArrayList<>();
//         items.add(new Item("Item 1", "Item 1 Description"));
//         items.add(new Item("Item 2", "Item 2 Description"));
//         when(boxRepository.findById(boxId)).thenReturn(Optional.of(box));
//         when(boxRepository.save(box)).thenReturn(box);

//         CompletableFuture<Box> futureBox = boxService.addItemsToBox(boxId, items);

//         assertNotNull(futureBox);
//         assertEquals(box, futureBox.join());
//         assertEquals(items.size(), box.getItems().size());
//         verify(boxRepository, times(1)).findById(boxId);
//         verify(boxRepository, times(1)).save(box);
//     }

//     @Test
//     void testSaveSubscriptionBox() {
//         Box subscriptionBox = new Box("Test Box", "Test Description", 10.0);
//         when(boxRepository.save(subscriptionBox)).thenReturn(subscriptionBox);

//         Box savedBox = boxService.saveSubscriptionBox(subscriptionBox);

//         assertNotNull(savedBox);
//         assertEquals(subscriptionBox, savedBox);
//         verify(boxRepository, times(1)).save(subscriptionBox);
//     }

//     @Test
//     void testGetAllBoxes() {
//         List<Box> boxes = new ArrayList<>();
//         boxes.add(new Box("Box 1", "Description 1", 10.0));
//         boxes.add(new Box("Box 2", "Description 2", 20.0));
//         when(boxRepository.findAll()).thenReturn(boxes);

//         List<Box> retrievedBoxes = boxService.getAllBoxes();

//         assertNotNull(retrievedBoxes);
//         assertEquals(boxes.size(), retrievedBoxes.size());
//         assertEquals(boxes, retrievedBoxes);
//         verify(boxRepository, times(1)).findAll();
//     }
// }