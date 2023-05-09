package com.example.sprinjpaproject2.repositories;

import com.example.sprinjpaproject2.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Jpa repositorynin ilk elemanı Customerı yani entity sınıfını alır
//2. elemenanı da Customer içindeki id'nin türünü belirtmek gerekir. Benim entityimde türü Longdur
public interface CustomerRepository extends JpaRepository<Customer,Long> {
        //Nonealableları optional typelarla kontrol edebiliriz.
        //Optional wrap type
        Optional<Customer> findByEmailEqualsAndPasswordEquals(String email, String Password);

}
