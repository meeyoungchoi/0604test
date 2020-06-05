package com.example.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//아이디를 증가시킬때 왜 디비에 들어간 아이디를 증가시키는가?

    private String name;
    private Integer price;

    @ManyToMany
    private List<Ingredient> ingredients;

}
