package com.example.Cafe.Repository;

import model.Dish;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DishRepository {

   public Map<Long, Dish> dishMap = new HashMap<>();
    Long id = 0L;
    public Long generateId(){
        return ++id;
    }


}
