package com.example.Cafe.service;

import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;
import com.example.Cafe.model.Dish;

import java.util.List;

public interface DishService {
    ServerResponceDto DishAdd (ServerRequestDto serverRequestDto);
    ServerResponceDto getDish(Long id);
    List<ServerResponceDto> getAllDish();
    ServerResponceDto updateDish(Long id , ServerRequestDto serverRequestDto);

    GenericResponceDto delete(Long id);

    List<ServerResponceDto> findDishByName(String q);
    List<ServerResponceDto> findDishByNameAndPrice(String q , Long min , Long max);

    Dish getDishByCustomMethod(Long id);
    List<Dish> getDishByNativeQuery(String name);

}
