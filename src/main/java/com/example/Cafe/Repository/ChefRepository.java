package com.example.Cafe.Repository;

import com.example.Cafe.enums.Cuisine;
import com.example.Cafe.model.Chef;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefRepository extends JpaRepository<Chef,Long> {
    // highly not recommended use save() method
    @Modifying
    @Transactional
    @Query(value="INSERT INTO Chef (name,experience , cuisine) values(?1,?2,?3)", nativeQuery=true)
    void insertChefDetails(String name, String experience, String cuisine);

    default void insertChefDetails(String name, String experience, Cuisine cuisine){
        insertChefDetails(name,experience,cuisine.name());
    }

    @Query(value = "SELECT a.* FROM Chef a WHERE a.id=:identity", nativeQuery=true)
    Chef getChefById(@Param("identity") Long id);

    @Query(value="SELECT * from Chef" , nativeQuery = true)
    List<Chef> AllChef ();

    //@Query(value = "UPADTE Chef ")

    @Modifying
    @Transactional
    @Query(value = "DELETE from Chef where id =?1", nativeQuery = true)
    void deleteChef(Long id);
}
