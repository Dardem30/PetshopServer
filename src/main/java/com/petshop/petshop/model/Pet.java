package com.petshop.petshop.model;

import com.petshop.petshop.model.security.model.User;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
//import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
//@XmlRootElement(name = "pet")
public class Pet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private int age;
   @Column(name = "user_id")
   private Integer userId;
}
