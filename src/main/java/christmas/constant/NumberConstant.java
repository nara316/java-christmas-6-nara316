package christmas.constant;

public enum NumberConstant {

    START_DATE(1),
    END_DATE(31),
    ORDER_QUANTITY_MIN(1),
    ORDER_QUANTITY_TOTAL_MAX(20),
    GIFT_STANDARD(120_000),
    PROMOTION_STANDARD(10_000),
    PROMOTION_NOT_QUALIFIED(0),
    PROMOTION_DISCOUNT(1_000),
    CHRISTMAS_DISCOUNT(100),
    CHRISTMAS_PROMOTION_DEADLINE(25);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
