package com.example.test.controller;

import com.example.test.dto.BurgerForm;
import com.example.test.repository.BurgerRepository;
import com.example.test.repository.IngredientRepository;
import com.example.test.vo.Burger;
import com.example.test.vo.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class BurgerController {

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Burger> burgerList = burgerRepository.findAll();
        model.addAttribute("burgerList",burgerList);
        return "burgers/index";
    }

    @GetMapping("/init")
    public String init() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(null,"소스", 100));
        ingredients.add(new Ingredient(null,"야채", 300));
        ingredients.add(new Ingredient(null,"패티", 800));

        ingredientRepository.saveAll(ingredients);

        return "redirect:/";
    }

    @GetMapping("/burgers/new")
    public String newBurger(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "burgers/new";
    }

    @PostMapping("/burgers")
    public String create(BurgerForm form) {
        log.info(form.toString());

        Burger burger = form.toEntity();
        log.info(burger.toString());

        Burger saved = burgerRepository.save(burger);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping("/burgers/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Burger burger = burgerRepository.findById(id).orElse(null);
        model.addAttribute("burger",burger);
        return "burgers/edit";
    }

    @PostMapping("/burgers/{id}")
    public String update(BurgerForm form) {
        log.info(form.toString());

        Burger burger = form.toEntity();
        log.info(burger.toString());

        Burger saved = burgerRepository.save(burger);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping("/burgers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        burgerRepository.deleteById(id);
        log.info(id + "삭제");
        return "redirect:/";
    }

    @GetMapping("/burgers/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Burger burger = burgerRepository.findById(id).orElse(null);
        model.addAttribute("burger", burger);
        return "burgers/show";
    }
}
