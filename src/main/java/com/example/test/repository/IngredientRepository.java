package com.example.test.repository;

import com.example.test.vo.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    @Override
    List<Ingredient> findAll();
}
