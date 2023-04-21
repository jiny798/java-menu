package menu.utils;

public enum Food {
    //일식
    규동(Category.일식),
    우동(Category.일식),
    미소시루(Category.일식),
    스시(Category.일식),
    가츠동(Category.일식),
    오니기리(Category.일식),
    하이라이스(Category.일식),
    라멘(Category.일식),
    오코노미야끼(Category.일식),

    //한식
    김밥(Category.한식),
    김치찌개(Category.한식),
    쌈밥(Category.한식),
    된장찌개(Category.한식),
    비빔밥(Category.한식),
    칼국수(Category.한식),
    불고기(Category.한식),
    떡볶이(Category.한식),
    제육볶음(Category.한식),

    //중식
    깐풍기(Category.중식),
    볶음면(Category.중식),
    동파육(Category.중식),
    짜장면(Category.중식),
    짬뽕(Category.중식),
    마파두부(Category.중식),
    탕수육(Category.중식),
    토마토_달걀볶음(Category.중식),
    고추잡채(Category.중식),

    //아시안
    팟타이(Category.아시안),
    카오_팟(Category.아시안),
    나시고렝(Category.아시안),
    파인애플_볶음밥(Category.아시안),
    쌀국수(Category.아시안),
    똠얌꿍(Category.아시안),
    반미(Category.아시안),
    월남쌈(Category.아시안),
    분짜(Category.아시안),

    //양식
    라자냐(Category.양식),
    그라탱(Category.양식),
    뇨끼(Category.양식),
    끼슈(Category.양식),
    프렌치_토스트(Category.양식),
    바게트(Category.양식),
    스파게티(Category.양식),
    피자(Category.양식),
    파니(Category.양식);

    private final Category category;

    Food(Category category){
        this.category = category;
    }
}
