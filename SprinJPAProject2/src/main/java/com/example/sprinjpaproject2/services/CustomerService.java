package com.example.sprinjpaproject2.services;
import com.example.sprinjpaproject2.entities.Customer;
import com.example.sprinjpaproject2.repositories.CustomerRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Dependency Injection
public class CustomerService {
    public Customer login(String email, String password) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsAndPasswordEquals(email,password);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return null;
    }

    //Ara Katman veya Business Katmanı
    //Database metodlarla erişmek ve başkasının da bu metodlara erişebilmesi daha iyi olur.
    //Serviceler database erişimleri için kullanılır.
    final CustomerRepository customerRepository; //Dependency Injection


    //User Save Metodu.
    public Customer save(Customer customer){
        //customer statusunu kayıttan önce true'ya çekiyoruz.
        customer.setStatus(true);
        try {
            //Save işlemi yapıyoruz.
            return customerRepository.save(customer);
        }  catch (DataIntegrityViolationException ex){
            return customer;
            //Hata verirse burada yakalayacağız.

        }catch (Exception sql) {
            return null;
        }


    }

}
