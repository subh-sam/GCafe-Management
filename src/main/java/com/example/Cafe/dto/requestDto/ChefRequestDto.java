package com.example.Cafe.dto.requestDto;

import com.example.Cafe.enums.Cuisine;
import lombok.Data;

@Data
public class ChefRequestDto {
    private String name;
    private String experience;
    private Cuisine cuisine;
}
