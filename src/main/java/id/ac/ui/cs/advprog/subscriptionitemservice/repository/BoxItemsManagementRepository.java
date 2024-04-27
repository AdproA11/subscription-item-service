package id.ac.ui.cs.advprog.subscriptionitemservice.repository;

import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.subscriptionitemservice.model.*;
import java.util.ArrayList;
import java.util.Iterator;

@Repository
public class BoxItemsManagementRepository {
    private ArrayList<Box> listBoxes = new ArrayList<Box>();

    public BoxItemsManagement create (BoxItemsManagement box) {
        listBoxes.add(Box box);
        return box;
    }

    public Iterator<Box> findAll() {
        return listBoxes.iterator();
    }
}
// recommit to new branch