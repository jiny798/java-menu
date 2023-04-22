package menu.utils;

public enum ErrorMessage {
    COACH_NAME_LENGTH_ERROR("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 입니다."),
    COACH_PERSONNEL_ERROR("[ERROR] 코치는 최소 2명 이상,5명 이하 입력해야 합니다.");
    private final String msg;

    ErrorMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
