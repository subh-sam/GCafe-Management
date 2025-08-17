package com.example.Cafe.service;

import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;

import java.util.List;

public interface DishService {
    ServerResponceDto DishAdd (ServerRequestDto serverRequestDto);
    ServerResponceDto getDish(Long id);
    List<ServerResponceDto> getAllDish();
    ServerResponceDto updateDish(Long id , ServerRequestDto serverRequestDto);

    GenericResponceDto delete(Long id);

}
