package com.example.Cafe.service;

import com.example.Cafe.Repository.ChefRepository;
import com.example.Cafe.dto.requestDto.ChefRequestDto;
import com.example.Cafe.dto.responceDto.ChefResponseDto;
import com.example.Cafe.dto.responceDto.GenericResponceDto;
import com.example.Cafe.model.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChefServiceImpl implements ChefService {

    @Autowired
    ChefRepository chefRepository;

    @Override
    public GenericResponceDto registerChef(ChefRequestDto chefRequestDto) {
        Chef chef = new Chef();
        ChefRequestDtoToChef(chef, chefRequestDto);
        //chefRepository.save(chef);
        chefRepository.insertChefDetails(chef.getName(), chef.getExperience(), chef.getCuisine());
        String name = chef.getName();
        GenericResponceDto genericResponceDto = new GenericResponceDto();
        genericResponceDto.setSuccess(true);
        genericResponceDto.setDetails("Chef " + name + " Register Successfully ");
        genericResponceDto.setMessage("Chef " + name + " Register Successfully ");
        return genericResponceDto;
    }

    @Override
    public ChefResponseDto getChef(Long id) {
        Chef chef = chefRepository.getChefById(id);
        return ChefToChefResponseDTO(chef);
    }

    @Override
    public List<ChefResponseDto> getAllChef() {
        List<Chef> chefs = chefRepository.AllChef();
        List<ChefResponseDto> chefResponse = new ArrayList<>();
        for (Chef chef1 : chefs) {
            ChefResponseDto chef = new ChefResponseDto();
            chef.setId(chef1.getId());
            chef.setName(chef1.getName());
            chef.setExperience(chef1.getExperience());
            chef.setCuisine(chef1.getCuisine());
            chefResponse.add(chef);
        }
        return chefResponse;
    }

    @Override
    public ChefResponseDto UpdateChef(Long id, ChefRequestDto chefRequestDto) {
        Chef chef = chefRepository.findById(id).orElse(null);

        chef.setName(chefRequestDto.getName());
        chef.setExperience(chefRequestDto.getExperience());
        chef.setCuisine(chefRequestDto.getCuisine());
        chefRepository.save(chef);

        ChefResponseDto chefResponseDto = new ChefResponseDto();
        chefResponseDto.setId(id);
        chefResponseDto.setName(chef.getName());
        chefResponseDto.setExperience(chef.getExperience());
        chefResponseDto.setCuisine(chef.getCuisine());
        return chefResponseDto;
    }

    @Override
    public GenericResponceDto removeChef(Long id) {
        Chef chef = chefRepository.findById(id).orElse(null);
        String name = chef.getName();
        chefRepository.deleteChef(id);
        GenericResponceDto genericResponceDto = new GenericResponceDto();
        genericResponceDto.setSuccess(true);
        genericResponceDto.setMessage("Chef "+name+" Has Been Removed");
        genericResponceDto.setDetails("Hii Today Is 12-09-2025");
        return genericResponceDto;
    }


    // Custom Method To Convert ChefRequestDto to chef

    Chef ChefRequestDtoToChef(Chef chef, ChefRequestDto chefRequestDto) {
        chef.setName(chefRequestDto.getName());
        chef.setExperience(chefRequestDto.getExperience());
        chef.setCuisine(chefRequestDto.getCuisine());
        return chef;
    }

    // Custom Method To Convert Chef to ChefResponseDTO
    ChefResponseDto ChefToChefResponseDTO(Chef chef) {
        ChefResponseDto chefResponseDto = new ChefResponseDto();
        chefResponseDto.setId(chef.getId());
        chefResponseDto.setName(chef.getName());
        chefResponseDto.setExperience(chef.getExperience());
        chefResponseDto.setCuisine(chef.getCuisine());
        return chefResponseDto;
    }

}
