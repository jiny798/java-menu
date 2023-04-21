package menu.domain;

import menu.utils.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Coach {
    private String name;
    private List<Food> dislikeFoods = new ArrayList<>();
    private List<Food> recommendFoods = new ArrayList<>();

    private Coach(String name){
        this.name = name;
    }

    public static Coach createCoach(String name){
        return new Coach(name);
    }

    public String getName(){
        return name;
    }

    public void addDisLikeFood(Food food){
        this.dislikeFoods.add(food);
    }

    public boolean isDisLikeFood(Food food){
        return dislikeFoods.contains(food);
    }

    public List<Food> getRecommendFoods(){
        return this.recommendFoods;
    }

    public String toMessage(){
        StringJoiner joiner = new StringJoiner(" | ");
        joiner.add(this.getName());
        recommendFoods.stream()
                .map(food-> joiner.add(food.name()) )
                .collect(Collectors.toList());
        return joiner.toString();
    }
}
