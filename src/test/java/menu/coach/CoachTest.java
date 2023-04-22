package menu.coach;

import menu.controller.Validator;
import menu.domain.Coach;
import menu.utils.ErrorMessage;
import menu.utils.Food;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CoachTest {

    @Test
    void Couch_이름_최소2글자_최대4글자_예외() {
        Assertions.assertThatThrownBy(()-> Coach.createCoach("진"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining(ErrorMessage.COACH_NAME_LENGTH_ERROR.getMsg());

        Assertions.assertThatThrownBy(()-> Coach.createCoach("진진진진진"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_NAME_LENGTH_ERROR.getMsg());

    }

    @Test
    void Couch_인원_최소2명_최대5명_예외(){
        List<Coach> coachList = List.of(Coach.createCoach("박진"));

        Assertions.assertThatThrownBy(()->Validator.validationCoachList(coachList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_PERSONNEL_ERROR.getMsg());

    }

    @Test
    void Count_못먹는메뉴_최대2개_예외(){
        Coach coach = Coach.createCoach("박진군");
        List<Food> foodList = List.of(Food.규동,Food.김밥,Food.끼슈);

        Assertions.assertThatThrownBy(()->{
            for(Food food : foodList){
                coach.addDisLikeFood(food);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_DISLIKE_FOOD_COUNT_ERROR.getMsg());
    }

}
