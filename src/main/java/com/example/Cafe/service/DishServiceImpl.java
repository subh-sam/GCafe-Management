package com.example.Cafe.service;

import com.example.Cafe.Repository.DishRepository;
import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;
import com.example.Cafe.model.Dish;
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
        Dish dish = new Dish();

        dish = ServerRequestDtoToDish(dish,serverRequestDto);
        dishRepository.save(dish);
        return dishToServerResponseDto(dish);
    }

    @Override
    public ServerResponceDto getDish(Long id) {
        Dish dish = dishRepository.getReferenceById(id);
        return dishToServerResponseDto(dish);

    }

    @Override
    public List<ServerResponceDto> getAllDish() {

        List<Dish> dishList = new ArrayList<>(dishRepository.findAll());
        List<ServerResponceDto> serverResponceDtos = new ArrayList<>();
        for(Dish dish : dishList){
            //ServerResponceDto add = dishToServerResponseDto(dish);
            serverResponceDtos.add(dishToServerResponseDto(dish));
        }
        return serverResponceDtos;
    }

    @Override
    public ServerResponceDto updateDish(Long id, ServerRequestDto serverRequestDto) {
        Dish dish = dishRepository.getReferenceById(id);

        dish = ServerRequestDtoToDish(dish,serverRequestDto);
        dishRepository.save(dish);
        return dishToServerResponseDto(dish);


    }

    @Override
    public GenericResponceDto delete(Long id) {
        Dish dish = dishRepository.getReferenceById(id);
        GenericResponceDto genericResponceDto = new GenericResponceDto();
        String name = dish.getName();
        if (name != null){
            dishRepository.deleteById(id);
            genericResponceDto.setSuccess(true);
            genericResponceDto.setMessage("Dish ("+id+") "+name+" has been removed Successfully");
        }else {
            genericResponceDto.setSuccess(false);
            genericResponceDto.setMessage("Dish ("+id+") Not found");
        }
        return genericResponceDto;
    }

    @Override
    public List<ServerResponceDto> findDishByName(String name) {
        List<Dish> filterDish = dishRepository.findByNameContaining(name);
        List<ServerResponceDto> serverResponceDtos = new ArrayList<>();
        for (Dish dish : filterDish){
            serverResponceDtos.add(dishToServerResponseDto(dish));
        }

        return serverResponceDtos;
    }

    @Override
    public List<ServerResponceDto> findDishByNameAndPrice(String q ,Long min , Long max) {
        List<Dish> dishList = dishRepository.findByNameContainingAndPriceBetween(q,min,max);
        List<ServerResponceDto> serverResponceDtos = new ArrayList<>();
        for (Dish dish:dishList){
           serverResponceDtos.add(dishToServerResponseDto(dish));
        }
        return serverResponceDtos;
    }

    @Override
    public Dish getDishByCustomMethod(Long id) {
        return dishRepository.getDishByIdUsingCustomMethod(id);
    }

    @Override
    public List<Dish> getDishByNativeQuery(String name) {
        return dishRepository.getDishByNativeQuery(name);
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
