package com.example.sprinjpaproject2.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;


    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String surname;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 50)
    private String password;

    private Integer age;

    private Boolean status;


}
