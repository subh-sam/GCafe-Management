package com.example.Cafe.controller;

import com.example.Cafe.dto.requestDto.ChefRequestDto;
import com.example.Cafe.dto.responceDto.ChefResponseDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.service.ChefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Chef")
public class ChefController {
    @Autowired
    ChefServiceImpl chefServiceImple;

    @PostMapping
    GenericResponceDto ChefDetails(@RequestBody ChefRequestDto chefRequestDto){
        return chefServiceImple.registerChef(chefRequestDto);
    }

    @GetMapping("/{id}")
    ChefResponseDto GetChefDetails(@PathVariable Long id){
        return chefServiceImple.getChef(id);
    }

    @GetMapping()
    ResponseEntity<List<ChefResponseDto>> AllChefDetails (){
        return new ResponseEntity<>(chefServiceImple.getAllChef(), HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}" +
            "" +
            "")
    ChefResponseDto chefResponseDto(@PathVariable Long id ,@RequestBody ChefRequestDto chefRequestDto){
        return chefServiceImple.UpdateChef(id , chefRequestDto);
    }

    @DeleteMapping("/{id}/delete")
    ResponseEntity<GenericResponceDto> deleteChefDetails(@PathVariable Long id){
        return new ResponseEntity<>(chefServiceImple.removeChef(id),HttpStatusCode.valueOf(200));
    }
}
