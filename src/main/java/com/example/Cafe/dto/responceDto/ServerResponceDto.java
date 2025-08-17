package com.example.Cafe.dto.responceDto;

import com.example.Cafe.enums.DishCategory;
import lombok.Data;

@Data
public class ServerResponceDto {
    private Long id;
    private String name;
    private String price;
    private DishCategory category;


}
