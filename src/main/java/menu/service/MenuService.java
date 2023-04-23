package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.utils.Category;
import menu.utils.Food;

import java.util.*;
import java.util.stream.Collectors;

public class MenuService {

    private Map<Category,Integer> map = new HashMap<>();
    public List<Category> selectMenu(List<Coach> coachList) {
        List<Category> categoryList = new ArrayList<>();
        selectCategory(coachList,categoryList); // categoryList에 카테고리 5개 담기

//        runRecommend(coachList,categoryList); // 각 코치별 먹을 음식 담기
        return categoryList;
    }

    public void selectCategory(List<Coach> coachList,List<Category> categoryList){
        while(categoryList.size() < 5){
            int num = Randoms.pickNumberInRange(1,5);
            Category category = Category.createCategory(num);

            if(isOutOfCountCategory(category)){
                continue;
            }
            putMap(category);
            categoryList.add(category);
            runRecommend(coachList,category);

        }
    }
    public boolean isOutOfCountCategory(Category category){
        if(map.get(category)==null || map.get(category) <= 1){
            return false;
        }
        return true;
    }

    public void putMap(Category category){
        if(map.get(category)==null){
            map.put(category,1);
            return;
        }
        map.put(category, map.get(category)+1);

    }
    public void runRecommend(List<Coach> coachList,Category category){
        for(int i=0;i<coachList.size();i++){
            Coach findCoach = coachList.get(i);
            selectFoodList(findCoach,category);
        }
    }

    public void selectFoodList(Coach coach,Category category){
        List<Food> dislikeFoods = coach.getDislikeFoods();

        List<String> string_foods = Food.getFoodNameList(category.name());
        int index=0;
        while (index==0) {
            String foodName = Randoms.shuffle(string_foods).get(0);
            foodName = foodName.replaceAll(" ", "_");
            Food selectedFood = Food.createFood(foodName);

            if (dislikeFoods.contains(selectedFood)) {
                continue;
            }
            coach.addRecommendFood(selectedFood);
            index++;
        }
    }

}
