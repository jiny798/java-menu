package menu.domain;

import menu.controller.Validator;
import menu.utils.ErrorMessage;
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
        if(!validateName(name)){
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR.getMsg());
        }
        this.name = name;
    }
    public boolean validateName(String name){
        if(name.length()<2 || name.length()>4){
            return false;
        }
        return true;
    }

    public static Coach createCoach(String name){
        return new Coach(name);
    }

    public String getName(){
        return name;
    }

    public void addDisLikeFood(Food food){
        validationDisLikeFoodList(dislikeFoods);
        this.dislikeFoods.add(food);
    }

    public void validationDisLikeFoodList(List<Food> dislikeFoods){
        if(dislikeFoods.size() >= 2){
            dislikeFoods.clear();
            throw new IllegalArgumentException(ErrorMessage.COACH_DISLIKE_FOOD_COUNT_ERROR.getMsg());
        }
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
        return "[ "+joiner.toString()+" ]";
    }
}
