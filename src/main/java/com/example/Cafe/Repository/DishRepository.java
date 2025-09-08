package com.example.Cafe.Repository;

import com.example.Cafe.dto.responceDto.ServerResponceDto;
import com.example.Cafe.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish , Long>  {
    List<Dish> findByNameContaining (String name);
    List<Dish> findByNameContainingAndPriceBetween(String name , Long min, Long max);
    @Query("SELECT a FROM Dish a WHERE a.id = :identity")
    Dish getDishByIdUsingCustomMethod(@Param("identity") Long id);

    @Query(value = "SELECT a.* FROM Cafe_table a Where a.name=?1" , nativeQuery = true)
    List<Dish> getDishByNativeQuery(String name);

}
