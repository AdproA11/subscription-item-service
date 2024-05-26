package id.ac.ui.cs.advprog.subscriptionitemservice.component;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import id.ac.ui.cs.advprog.subscriptionitemservice.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private BoxRepository boxRepository;

    @Override
    public void run(String... args) throws Exception {
        // Real Madrid themed box
        Box box1 = new Box("Real Madrid Box", "Random Real Madrid Merchandise", 750.000);
        Item item1 = new Item("Real Madrid Home 2023/2024", "Jersey Home yang disertai patch UCL");
        Item item2 = new Item("Real Madrid Away 2023/2024", "Jersey Away yang disertai patch UCL");
        box1.setItems(new ArrayList<>(Arrays.asList(item1, item2)));
        boxRepository.save(box1);

        // Manchester United themed box
        Box box2 = new Box("Manchester United Box", "Random Manchester United Merchandise", 500.000);
        Item item3 = new Item("Manchester United Home 2023/2024", "Jersey Home yang disertai patch UEL");
        Item item4 = new Item("Manchester United Away 2023/2024", "Jersey Away yang disertai patch UEL");
        box2.setItems(new ArrayList<>(Arrays.asList(item3, item4)));
        boxRepository.save(box2);

        // Barcelona themed box
        Box box3 = new Box("Barcelona Box", "Random Barcelona Merchandise", 800.000);
        Item item5 = new Item("Barcelona Home 2023/2024", "Jersey Home yang disertai patch La Liga");
        Item item6 = new Item("Barcelona Away 2023/2024", "Jersey Away yang disertai patch La Liga");
        box3.setItems(new ArrayList<>(Arrays.asList(item5, item6)));
        boxRepository.save(box3);
    }
}