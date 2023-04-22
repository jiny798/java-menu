package menu.coach;

import menu.controller.Validator;
import menu.domain.Coach;
import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
