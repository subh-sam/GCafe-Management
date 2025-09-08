package com.example.Cafe.model;

import com.example.Cafe.enums.DishCategory;
import jakarta.persistence.*;
import lombok.Data;
@Table(name="Cafe_table")
@Entity
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @Enumerated(EnumType.STRING)
    private DishCategory category;


}
