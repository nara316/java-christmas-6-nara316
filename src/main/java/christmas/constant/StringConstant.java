package christmas.constant;

public enum StringConstant {

    DIVISION_ORDERS(","),
    DIVISION_MENU_AND_QUANTITY("-");

    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
