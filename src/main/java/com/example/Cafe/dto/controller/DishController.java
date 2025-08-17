package com.example.Cafe.dto.controller;

import com.example.Cafe.dto.requestDto.ServerRequestDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.dto.responceDto.ServerResponceDto;
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

    @GetMapping("/{getAllDish}")
    List<ServerResponceDto> getAllDIsh(){
        return dishService.getAllDish();
    }

    @PostMapping
    ServerResponceDto addDish(@RequestBody ServerRequestDto serverRequestDto){
        return dishService.DishAdd(serverRequestDto);
    }

    @PutMapping("/{id}")
    ServerResponceDto updateDish(@PathVariable Long id , @RequestBody ServerRequestDto serverRequestDto){
        return dishService.updateDish(id,serverRequestDto);
    }

    @DeleteMapping("/{id}")
    GenericResponceDto removeDish(@PathVariable Long id){
        return dishService.delete(id);
    }
}
