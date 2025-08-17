package com.example.Cafe.service;

import com.example.Cafe.Repository.DishRepository;
import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;
import model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    DishRepository dishRepository;

    @Override
    public ServerResponceDto DishAdd(ServerRequestDto serverRequestDto) {
       Long id = dishRepository.generateId();
        Dish dish = new Dish();
        dish.setId(id);

        dish = ServerRequestDtoToDish(dish,serverRequestDto);

        dishRepository.dishMap.put(id,dish);
        dish = dishRepository.dishMap.get(id);
        return dishToServerResponseDto(dish);
    }

    @Override
    public ServerResponceDto getDish(Long id) {
        Dish dish = dishRepository.dishMap.get(id);
        return dishToServerResponseDto(dish);

    }

    @Override
    public List<ServerResponceDto> getAllDish() {

        List<Dish> dishList = new ArrayList<>(dishRepository.dishMap.values());
        List<ServerResponceDto> serverResponceDtos = new ArrayList<>();
        for(Dish dish : dishList){
            //ServerResponceDto add = dishToServerResponseDto(dish);
            serverResponceDtos.add(dishToServerResponseDto(dish));
        }
        return serverResponceDtos;
    }

    @Override
    public ServerResponceDto updateDish(Long id, ServerRequestDto serverRequestDto) {
        Dish dish = dishRepository.dishMap.get(id);

        dish = dishRepository.dishMap.put(id,dish);

            Dish dish1 = ServerRequestDtoToDish(dish, serverRequestDto);
            return dishToServerResponseDto(dish1);


    }

    @Override
    public GenericResponceDto delete(Long id) {
        Dish dish = dishRepository.dishMap.get(id);
        GenericResponceDto genericResponceDto = new GenericResponceDto();
        String name = dish.getName();
        if (name != null){
            dishRepository.dishMap.remove(id);
            genericResponceDto.setSuccess(true);
            genericResponceDto.setMessage("Dish ("+id+") "+name+" has been removed Successfully");
        }else {
            genericResponceDto.setSuccess(true);
            genericResponceDto.setMessage("Dish ("+id+") Not found");
        }
        return genericResponceDto;
    }


    // Dish to ServerResponseDto
    ServerResponceDto dishToServerResponseDto(Dish dish){
        ServerResponceDto serverResponceDto = new ServerResponceDto();
        serverResponceDto.setId(dish.getId());
        serverResponceDto.setName(dish.getName());
        serverResponceDto.setCategory(dish.getCategory());
        serverResponceDto.setPrice(dish.getPrice());

        return serverResponceDto;
    }

    // ServerRequestDto to Dish Convert

    Dish ServerRequestDtoToDish(Dish dish ,ServerRequestDto serverRequestDto){

        dish.setName(serverRequestDto.getName());
        dish.setCategory(serverRequestDto.getCategory());
        dish.setPrice(serverRequestDto.getPrice());
        return dish;

    }
}
