package com.example.Cafe.service;

import com.example.Cafe.dto.requestDto.ChefRequestDto;
import com.example.Cafe.dto.responceDto.ChefResponseDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;

import java.util.List;

public interface ChefService {
    GenericResponceDto registerChef(ChefRequestDto chefRequestDto);
    ChefResponseDto getChef(Long id);
    List<ChefResponseDto> getAllChef();
    ChefResponseDto UpdateChef(Long id , ChefRequestDto chefRequestDto);
    GenericResponceDto removeChef(Long id);
}
