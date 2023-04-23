package menu.controller;

import menu.domain.Coach;
import menu.service.MenuService;
import menu.utils.Category;
import menu.utils.ErrorMessage;
import menu.utils.Food;
import menu.utils.OutputMessage;
import menu.view.MenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MenuController {

    private final MenuView menuView;
    private final MenuService menuService;

    public MenuController(){
        this.menuService=new MenuService();
        this.menuView = new MenuView();
    }

    public void run(){
        List<Coach> coachList = new ArrayList<>();
        System.out.println(OutputMessage.INIT_MESSAGE.getMessage()+"\n");
        inputCoachList(coachList);

        readDisLikeFood(coachList);

        List<Category> categoryList = menuService.selectMenu(coachList);

        System.out.println(OutputMessage.RECOMMENDED_RESULT.getMessage());
        menuView.printMenuListByCoaches(coachList,categoryList);
        System.out.println(OutputMessage.EXIT_MESSAGE.getMessage());
    }

    public void readDisLikeFood(List<Coach> coachNames){
        coachNames.stream()
                .forEach(o->{
                    repeat(() -> menuView.inputDislikeFood(o));
                });
    }

    public void inputCoachList(List<Coach> coachList){
        try {
            List<Coach> coaches = repeat(()->menuView.inputCoachName());
            Validator.validationCoachList(coaches);
            coaches.stream()
                    .forEach(o->{
                        coachList.add(o);
                    });

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            inputCoachList(coachList);
        }

    }

    public <T> T repeat(Supplier<T> read){
        try {
            return read.get();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return repeat(read);
        }
    }
}
