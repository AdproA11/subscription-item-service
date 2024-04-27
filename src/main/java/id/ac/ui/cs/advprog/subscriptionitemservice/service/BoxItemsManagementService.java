package id.ac.ui.cs.advprog.subscriptionitemservice.service;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.BoxItemsManagement;
import java.util.ArrayList;

public interface BoxItemsManagementService {
    public BoxItemsManagement create(BoxItemsManagement boxItemsManagement);
    public ArrayList<BoxItemsManagement> findAll();
}
