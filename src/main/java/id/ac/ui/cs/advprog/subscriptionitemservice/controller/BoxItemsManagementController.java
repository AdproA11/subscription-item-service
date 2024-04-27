package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.BoxItemsManagement;
import id.ac.ui.cs.advprog.subscriptionitemservice.service.BoxItemsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class BoxItemsManagementController {
    @GetMapping("/")
    @ResponseBody
    public String addItem() {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/")
    public String getAdminPage(Model model) {
        model.addAttribute("boxes", service.findAll());
        return "admin";
    }

    @Autowired
    private BoxItemsManagementService service;

    @GetMapping("/addBox")
    public String addBox() {
        BoxItemsManagement newBoxItem = new BoxItem();
        model.addAttribute("boxItem", newBoxItem);
        return "addBox";
    }

    @PostMapping("/addBox")
    public String addBoxPost(BoxItemsManagement boxItem) {
        service.save(boxItem);
        return "redirect:/admin/";
    }
}