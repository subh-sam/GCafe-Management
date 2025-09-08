package com.example.Cafe.dto.requestDto;

import com.example.Cafe.enums.DishCategory;
import lombok.Data;

@Data
public class ServerRequestDto {
    private String name;
    private Long price;
    private DishCategory category;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getPrice() {
//        return price;
//    }
//
//    public void setPrice(Long price) {
//        this.price = price;
//    }
//
//    public DishCategory getCategory() {
//        return category;
//    }
//
//    public void setCategory(DishCategory category) {
//        this.category = category;
//    }
}
