package christmas.constant;

public enum NumberConstant {

    START_DATE(1),
    END_DATE(31),
    ORDER_AMOUNT_MIN(1),
    ORDER_AMOUNT_TOTAL_MAX(20);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
