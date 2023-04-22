package menu.controller;

import menu.domain.Coach;
import menu.utils.ErrorMessage;

import java.util.List;

public class Validator {
    public static void validationCoachList(List<Coach> coachList){
        if(coachList.size()<2 || coachList.size()>5){
            throw new IllegalArgumentException(ErrorMessage.COACH_PERSONNEL_ERROR.getMsg());
        }
    }
}
