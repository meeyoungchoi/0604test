package com.example.test.repository;

import com.example.test.vo.Burger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BurgerRepository extends CrudRepository<Burger, Integer> {

    @Override
    List<Burger> findAll();
}
