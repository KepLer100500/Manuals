package com.kepler.controllers;

import com.kepler.model.Product;
import com.kepler.processor.LoginProcessor;
import com.kepler.service.LoggedUserManagmentService;
import com.kepler.service.LoginCountService;
import com.kepler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private LoginProcessor loginProcessor;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private LoggedUserManagmentService loggedUserManagmentService;
   
    @RequestMapping("/home/{color}")
    // use link: http://localhost:8080/home/green?username=KepLer
    public String home(@PathVariable String color, 
                        @RequestParam(required = false) String username, 
                        Model page) {
        page.addAttribute("username", username);
        page.addAttribute("color", color);
        return "home.html";
    }
    
    @GetMapping("/login") 
    public String login(Model model) {
        model.addAttribute(
                "loginCount", 
                loginProcessor.getLoginCountService().getCount()
        );
        return "login.html";
    }
    
    @PostMapping("/login")
    public String tryToLogin(@RequestParam String username,
            @RequestParam String password, 
            Model model) {

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        
        if(loginProcessor.loggedIn()) {
            return "redirect:/";
        } else {
            model.addAttribute("message", "Failed");
        }
        
        model.addAttribute(
                "loginCount", 
                loginProcessor.getLoginCountService().getCount()
        );
        
        return "login.html";
    }
    
    @GetMapping("/")
    public String index(@RequestParam(required = false) String logout, Model model) {
        if(logout != null) {
            loggedUserManagmentService.setUsername(null);
        }
        
        String username = loggedUserManagmentService.getUsername();
        
        if(username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        
        return "index.html";
    }
    
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }
    
    @PostMapping("/products")
    public String addProduct(Model model, 
            @RequestParam String name,
            @RequestParam double price) {
        Product product = new Product(name, price);
        productService.addProduct(product);
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }
}
