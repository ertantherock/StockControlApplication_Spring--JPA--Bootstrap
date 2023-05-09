package com.example.sprinjpaproject2.controllers;

import com.example.sprinjpaproject2.entities.Customer;
import com.example.sprinjpaproject2.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    String error = "";
    String success = "";

    //Object poolda saklanır bu nesneler ve ihtiyacımız olduğunda final ile enjecte ettik.
    final CustomerService customerService; //Dependency Injection ile enjecte ettik. Newlemeye gerek kalmadı.
    //Neden final kullanıyoruz? Çünkü final ile ürettiğimizde customerService nihai halinde olacak ve değişmeyecek ve hata vermeyecek.

    @GetMapping("/")
    public String register(Model model){

        model.addAttribute("error", error);
        model.addAttribute("success",success);
        success = "";
        error = "";
//        Test login
//        Customer c = customerService.login("ertancank@gmail.com","12345");
//        System.out.println(c);
        return "register";
    }

    @PostMapping("/register")
    public String customerRegister(Customer customer){
        Customer c = customerService.save(customer);
        System.out.println(c); //Yazdırdık çünkü gelen değerleri doğru getiriyor mu görmek istedik.
        if (c != null && c.getCid() == null){

            error = customer.getEmail() + ": Bu mail adresi daha önce kayıtlı!";

        }else if(c != null && c.getCid() >0){
            success = customer.getName() + customer.getSurname() + ": Kullanıcı kayıt işlemi başarılı";
        }
        return "redirect:/";
    }
}
