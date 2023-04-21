package menu.controller;

import menu.domain.Coach;
import menu.service.MenuService;
import menu.utils.Category;
import menu.utils.Food;
import menu.utils.OutputMessage;
import menu.view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {

    private final MenuView menuView;
    private final MenuService menuService;

    public MenuController(){
        this.menuService=new MenuService();
        this.menuView = new MenuView();
    }

    public void run(){
        List<Coach> coachList = menuView.inputCoachName();
        readDisLikeFood(coachList);

        menuService.selectMenu(coachList);

        System.out.println(OutputMessage.RECOMMENDED_RESULT.getMessage());
        menuView.printMenuListByCoaches(coachList);
        System.out.println(OutputMessage.EXIT_MESSAGE.getMessage());
    }

    public void readDisLikeFood(List<Coach> coachNames){
        coachNames.stream()
                .map(menuView::inputDislikeFood)
                .collect(Collectors.toList());
    }

}
