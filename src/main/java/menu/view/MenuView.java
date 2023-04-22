package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.utils.Category;
import menu.utils.Food;
import menu.utils.OutputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MenuView {

    public List<Coach> inputCoachName(){
        System.out.println(OutputMessage.INIT_MESSAGE.getMessage()+"\n");
        System.out.println(OutputMessage.INPUT_COACH_NAMES.getMessage());
        String names = Console.readLine();
        String[] name_arr = names.split(",");
        List<Coach> coachList = Arrays.stream(name_arr)
                .map(Coach::createCoach)
                .collect(Collectors.toList());
        return coachList;
    }

    public String inputDislikeFood(Coach coach){
        System.out.printf(OutputMessage.INPUT_DISLIKE_FOOD.getMessage(),coach.getName());
        String names = Console.readLine();
        String[] name_arr = names.split(",");
        Arrays.stream(name_arr)
                .forEach(foodName ->{
                    Food food = Food.createFood(foodName);
                    coach.addDisLikeFood(food);
                });
        return "ok";
    }

    public void printMenuListByCoaches(List<Coach> coachList, List<Category> categoryList){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        StringJoiner joiner = new StringJoiner(" | ");
        for (Category category : categoryList){
            joiner.add(category.name());
        }
        System.out.println("[ "+joiner+" ]");

        for (Coach coach : coachList){
            System.out.println(coach.toMessage());
        }
    }


}
