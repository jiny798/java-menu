package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class MenuView {

    public List<String> inputCoachName(){
        String names = Console.readLine();
        String[] name_arr = names.split(",");
        return Arrays.asList(name_arr);
    }

    public List<String> inputDislikeFood(){
        String names = Console.readLine();
        String[] name_arr = names.split(",");
        return Arrays.asList(name_arr);
    }

}
