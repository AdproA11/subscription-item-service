// package id.ac.ui.cs.advprog.subscriptionitemservice.controller;

// import id.ac.ui.cs.advprog.subscriptionitemservice.model.BoxItem;
// import id.ac.ui.cs.advprog.subscriptionitemservice.model.Item;
// import id.ac.ui.cs.advprog.subscriptionitemservice.service.BoxItemsManagementService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import javax.swing.*;

// @Controller
// @RequestMapping("/admin")
// public class BoxItemsManagementController {
//     @GetMapping("/")
//     @ResponseBody
//     public String addItem() {
//         return "<h1>Hello World</h1>";
//     }

//     @GetMapping("/")
//     public String getAdminPage(Model model) {
//         model.addAttribute("boxes", service.findAll());
//         return "admin";
//     }

//     @Autowired
//     private BoxItemsManagementService service;

//     @GetMapping("/addBox")
//     public String addBox() {
//         BoxItem newBoxItem = new BoxItem();
//         model.addAttribute("boxItem", newBoxItem);
//         return "addBox";
//     }

//     @PostMapping("/addBox")
//     public String addBoxPost(BoxItem boxItem) {
//         service.save(boxItem);
//         return "redirect:/admin/";
//     }

//     @GetMapping("/listAllBoxes")
//     public String listAllBoxes(Model model) {
//         List<Box> boxes = service.findAll();
//         model.addAttribute("boxes", boxes);
//         return "listAllBoxes";
//     }

//     @GetMapping("/listAllItems/{boxId}")
//     public String listAllItems(@PathVariable Long boxId, Model model) {
//         Box box = service.findById(boxId);
//         List<Item> items = box.getArrItem();
//         model.addAttribute("items", items);
//         return "listAllItems";
//     }
// }