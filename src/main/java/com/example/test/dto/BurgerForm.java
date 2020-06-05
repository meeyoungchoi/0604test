package com.example.test.dto;

import com.example.test.vo.Burger;
import com.example.test.vo.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class BurgerForm {

    private Integer id;
    private String name;
    private Integer price;

    private List<Ingredient> ingredients;

    public Burger toEntity() {
        return new Burger(id, name , price, ingredients);
    }
}
