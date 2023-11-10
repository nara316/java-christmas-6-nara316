package christmas.constant;

public enum ExceptionConstant {

    ERROR_TITLE("[ERROR] "),
    INPUT_IS_ESSENTIAL("입력값은 필수입니다."),
    INPUT_IS_NUMBER("입력값은 정수만을 허용합니다."),
    VISIT_DATE_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    WRONG_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TITLE + message;
    }
}
