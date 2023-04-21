package menu.utils;

public enum OutputMessage {
    INIT_MESSAGE("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_DISLIKE_FOOD("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMENDED_RESULT("메뉴 추천 결과입니다."),
    EXIT_MESSAGE("추천을 완료했습니다.");

    private final String message;
    OutputMessage(String msg){
        this.message = msg;
    }

    public String getMessage(){
        return message;
    }
}
