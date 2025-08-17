package model;

import com.example.Cafe.enums.DishCategory;
import lombok.Data;

@Data
public class Dish {
    private Long id;
    private String name;
    private String price;
    private DishCategory category;


}
