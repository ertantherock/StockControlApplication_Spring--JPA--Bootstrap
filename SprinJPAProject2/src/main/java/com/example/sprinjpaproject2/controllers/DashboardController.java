package com.example.sprinjpaproject2.controllers;

import com.example.sprinjpaproject2.entities.Product;
import com.example.sprinjpaproject2.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    final ProductService productService;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("products", productService.allProduct());

        return "dashboard";
    }

    @PostMapping("/productSave")
    public String productSave(Product product){

        productService.save(product);

        return "redirect:/dashboard";
    }

    @GetMapping("/productDelete/{stPid}")
    public String productDelete(@PathVariable String stPid){
        boolean status= productService.productDelete(stPid);
        System.out.println("Status : "+status);

        return "redirect:/dashboard";
    }


}
