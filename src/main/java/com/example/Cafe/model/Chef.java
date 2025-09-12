package com.example.Cafe.model;

import com.example.Cafe.enums.Cuisine;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Chef")
@Data
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String experience;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
}
