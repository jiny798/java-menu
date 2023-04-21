package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.utils.Category;
import menu.utils.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MenuService {

    public void selectMenu(List<Coach> coachList) {
        List<Category> categoryList = new ArrayList<>();
        selectCategory(categoryList); // categoryList에 카테고리 5개 담기

        runRecommend(coachList,categoryList); // 각 코치별 먹을 음식 담기

    }

    public void selectCategory(List<Category> categoryList){
        while(categoryList.size() < 5){
            int num = Randoms.pickNumberInRange(1,5);
            Category category = Category.createCategory(num);
            if(isOutOfCountCategory(category)){
                continue;
            }
            categoryList.add(category);
        }
    }
    public boolean isOutOfCountCategory(Category category){
        return false;
    }

    public void runRecommend(List<Coach> coachList,List<Category> categoryList){
        for(int i=0;i<coachList.size();i++){
            Coach findCoach = coachList.get(i);
            selectFoodList(findCoach,categoryList);
        }
    }

    public void selectFoodList(Coach coach,List<Category> categoryList){

        for(int i=0;i<categoryList.size();i++){
            Category category = categoryList.get(i);
            List<Food> foods = Food.getFoodListByCategoryName(category.name());
            Food selectedFood = Randoms.shuffle(foods).get(0);

            coach.getRecommendFoods().add(selectedFood);
        }

    }

}
