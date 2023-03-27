package com.example.clase2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID")
    private int id;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "Phone")
    private String phone;
}
