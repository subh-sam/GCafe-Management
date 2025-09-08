package com.example.Cafe.controller;

import com.example.Cafe.Repository.DishRepository;
import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;
import com.example.Cafe.model.Dish;
import com.example.Cafe.service.DishService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    DishService dishService;

    // we can create our own message for print success code in postman
    @GetMapping
    ResponseEntity<ServerResponceDto> getDishById(@RequestParam Long id){
        return new ResponseEntity <>(dishService.getDish(id), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/filter/onName")
    ResponseEntity<List<ServerResponceDto>> filterValue(@RequestParam String q){
        return new ResponseEntity<>(dishService.findDishByName(q),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/filter/onPrice/{name}")
    ResponseEntity<List<ServerResponceDto>> filterWithNameAndPrice(@PathVariable String name, @RequestParam Long min, Long max){
        return new ResponseEntity<>(dishService.findDishByNameAndPrice(name, min, max),HttpStatusCode.valueOf(200));
    }


    @GetMapping("/{getAllDish}")
    ResponseEntity<List<ServerResponceDto>> getAllDIsh(){
        return new ResponseEntity<>( dishService.getAllDish(),HttpStatusCode.valueOf(200));
    }

    @PostMapping
    ResponseEntity<ServerResponceDto> addDish(@RequestBody ServerRequestDto serverRequestDto){
        return new ResponseEntity<>( dishService.DishAdd(serverRequestDto),HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    ServerResponceDto updateDish(@PathVariable Long id , @RequestBody ServerRequestDto serverRequestDto){
        return dishService.updateDish(id,serverRequestDto);
    }

    @DeleteMapping("/{id}")
    GenericResponceDto removeDish(@PathVariable Long id){
        return dishService.delete(id);
    }



    // By Pass Value

    @GetMapping("/")
    ResponseEntity<Dish> getDishByCustomRepo(@RequestParam Long getId){
        return new ResponseEntity<>(dishService.getDishByCustomMethod(getId),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/nativeQuery/{name}")
    ResponseEntity<List<Dish>> getDishByNativeQuery(@PathVariable String name){
        return new ResponseEntity<>(dishService.getDishByNativeQuery(name),HttpStatusCode.valueOf(200));
    }

}
