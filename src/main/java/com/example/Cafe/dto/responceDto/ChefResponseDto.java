package com.example.Cafe.dto.responceDto;
import com.example.Cafe.enums.Cuisine;
import lombok.Data;

@Data
public class ChefResponseDto {
    private Long id;
    private String name;
    private String experience;
    private Cuisine cuisine;
}
