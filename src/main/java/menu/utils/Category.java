package menu.utils;

public enum Category {
    일식(1),
    한식(2),
    중식(3),
    아시안(4),
    양식(5);

    private final int index;

    Category(int i){
        this.index = i;
    }
}
