package christmas.constant;

public enum NumberConstant {

    START_DATE(1),
    END_DATE(31),
    ORDER_QUANTITY_MIN(1),
    ORDER_QUANTITY_TOTAL_MAX(20),
    GIFT_APPLIED_STANDARD(120_000),
    PROMOTION_STANDARD(10_000),
    PROMOTION_NOT_APPLIED(0),
    PROMOTION_SPECIAL_DISCOUNT(1_000),
    PROMOTION_CHRISTMAS_DISCOUNT(1_000),
    PROMOTION_CHRISTMAS_DISCOUNT_PER_DAY(100),
    PROMOTION_CHRISTMAS_DEADLINE(25);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
